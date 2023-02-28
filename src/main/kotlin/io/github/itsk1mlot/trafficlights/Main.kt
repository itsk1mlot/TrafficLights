package io.github.itsk1mlot.trafficlights

import io.github.itsk1mlot.trafficlights.commands.ToggleTrafficLights
import io.github.itsk1mlot.trafficlights.events.CheckMovement
import io.github.itsk1mlot.trafficlights.events.LoadSystem
import org.bukkit.plugin.java.JavaPlugin
import org.slf4j.LoggerFactory

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

        /*
        I18n.loadBundles(
            Locale.KOREAN,
            Locale.ENGLISH,
            path = "/lang/lang_{languageTag}.properties",
            clazz = javaClass
        )
        */

        LoadSystem.main() // loop

        //logger.info(I18n.t("plugin_enabled"))
        //logger.info("hello")
        println("\n[TrafficLights] 시스템이 활성화되었습니다!\n")
    }

    override fun onDisable() {
        //logger.info(I18n.t("plugin_disabled"))
        //logger.info("bye")
        println("\n[TrafficLights] 시스템이 비활성화됩니다!\n")
    }
}