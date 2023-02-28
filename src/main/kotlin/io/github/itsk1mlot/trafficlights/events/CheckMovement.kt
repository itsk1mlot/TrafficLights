package io.github.itsk1mlot.trafficlights.events

import io.github.itsk1mlot.trafficlights.commands.ToggleTrafficLights
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent

class CheckMovement: Listener {

    @EventHandler
    fun onMovement(e: PlayerMoveEvent) {
        val systemCheck = ToggleTrafficLights.trafficlight
        val redlightCheck = ToggleTrafficLights.redLightStatus
        if (systemCheck && redlightCheck) {
            val p = e.player
            p.health = 0.0
            //Bukkit.broadcast(Component.text(I18n.t("death_message")))
            Bukkit.broadcast(Component.text("§e${p.name}§6님이 빨간불에 움직여서 사망하셨습니다!"))
        }
    }
}