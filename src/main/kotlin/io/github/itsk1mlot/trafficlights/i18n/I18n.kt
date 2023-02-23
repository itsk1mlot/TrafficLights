package io.github.itsk1mlot.trafficlights.i18n

import org.bukkit.entity.Player
import org.slf4j.LoggerFactory
import java.io.Reader
import java.text.MessageFormat
import java.util.*

fun Player.t(key: String, vararg args: Any?): String {
    return I18n.t(locale(), key, *args)
}

object I18n {

    private val bundles = mutableMapOf<Locale, I18NBundle>()

    var localeProvider = {
        Locale.getDefault()
    }

    fun availableLocales(): List<Locale> {
        return bundles.keys.toList()
    }

    fun clear() {
        bundles.clear()
    }

    fun addBundle(bundle: I18NBundle) {
        bundles[bundle.locale] = bundle
    }

    fun getBundle(locale: Locale): I18NBundle? {
        return bundles[locale]
    }

    fun getDefaultBundle(): I18NBundle {
        return bundles[Locale.ENGLISH]!!
    }

    fun loadBundle(locale: Locale, path: String, clazz: Class<Any> = javaClass) {
        addBundle(I18nBundleLoader.loadClasspath(path, locale, null, clazz))
    }

    fun loadBundles(locales: List<Locale>, path: String = "/translations/bundle_{languageTag}.properties", clazz: Class<Any> = javaClass) {
        locales.forEach {
            loadBundle(it, path.replace("{languageTag}", it.toLanguageTag()), clazz)
        }
    }

    fun loadBundles(vararg locales: Locale, path: String = "/translations/bundle_{languageTag}.properties", clazz: Class<Any> = javaClass) = loadBundles(locales.toList(), path, clazz)

    fun format(string: String, vararg args: Any): String {
        return try {
            MessageFormat.format(string, *args)
        } catch (e: Exception) {
            string
        }
    }

    fun t(locale: Locale, key: String, vararg args: Any?): String {
        val bundle = bundles[locale] ?: getDefaultBundle()
        return bundle.translate(key, *args)
    }

    fun t(key: String, vararg args: Any?): String {
        return t(localeProvider(), key, *args)
    }
}

class I18NBundle(
    val parent: I18NBundle?,
    val locale: Locale,
    private val properties: Map<String, String>
) {

    companion object {
        fun createEmptyBundle(): I18NBundle {
            return I18NBundle(null, Locale.getDefault(), emptyMap())
        }
    }

    fun has(key: String): Boolean {
        return properties.containsKey(key) || (parent?.has(key) ?: false)
    }

    fun get(key: String): String? {
        return properties[key] ?: parent?.get(key)
    }

    fun translate(key: String, vararg args: Any?): String {
        return MessageFormat.format(get(key) ?: "???${key}???", *args.map { it.toString() }.toTypedArray())
    }

}

object I18nBundleLoader {

    private val logger = LoggerFactory.getLogger("I18nBundleLoader")

    fun loadProperties(reader: Reader): Map<String, String> {
        val properties = Properties()
        properties.load(reader)
        return mapOf(*properties.stringPropertyNames().map { it to properties.getProperty(it) }.toTypedArray())
    }

    fun load(reader: Reader, locale: Locale, parent: I18NBundle? = null): I18NBundle {
        val properties = loadProperties(reader)
        return I18NBundle(
            parent = parent,
            locale = locale,
            properties = properties
        )
    }

    fun loadClasspath(path: String, locale: Locale, parent: I18NBundle? = null, clazz: Class<Any> = javaClass): I18NBundle {
        val reader = clazz.getResourceAsStream(path)?.reader()
        if(reader == null) {
            logger.error("${locale.displayName} failed to load from ${path}!")
            return I18NBundle.createEmptyBundle()
        }
        return load(reader, locale, parent)
    }

}
