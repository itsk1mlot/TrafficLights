package io.github.itsk1mlot.trafficlights

import io.github.itsk1mlot.trafficlights.commands.ToggleTrafficLights
import io.github.itsk1mlot.trafficlights.events.CheckMovement
import io.github.itsk1mlot.trafficlights.events.LoadSystem
import io.github.itsk1mlot.trafficlights.i18n.I18n
import org.bukkit.plugin.java.JavaPlugin
import org.slf4j.LoggerFactory
import java.util.*

class Main: JavaPlugin() {

    private val logger = LoggerFactory.getLogger("TrafficLights")

    companion object {
        lateinit var instance: Main
    }

    init {
        instance = this
    }

    override fun onEnable() {

        server.pluginManager.registerEvents(CheckMovement(), this)
        getCommand("tl")?.setExecutor(ToggleTrafficLights())

        I18n.loadBundles(
            Locale.KOREAN,
            Locale.ENGLISH,
            path = "/lang/lang_{languageTag}.properties",
            clazz = javaClass
        )

        LoadSystem.main()

        logger.info(I18n.t("plugin.enabled"))
    }

    override fun onDisable() {
        logger.info(I18n.t("plugin.disabled"))
    }
}