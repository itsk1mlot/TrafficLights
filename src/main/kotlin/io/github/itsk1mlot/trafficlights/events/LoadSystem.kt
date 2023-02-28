package io.github.itsk1mlot.trafficlights.events

import org.bukkit.scheduler.BukkitRunnable
import io.github.itsk1mlot.trafficlights.Main

object LoadSystem {
    class Runnable: BukkitRunnable() {
        override fun run() {
            println("test")
        }

    }
    fun main() {
        Runnable().runTaskTimer(Main.instance, 60000, 60000)
    }
}