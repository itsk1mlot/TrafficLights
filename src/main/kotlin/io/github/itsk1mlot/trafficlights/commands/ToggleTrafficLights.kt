package io.github.itsk1mlot.trafficlights.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import io.github.itsk1mlot.trafficlights.objects.Messages

class ToggleTrafficLights: CommandExecutor {

    companion object {
        var trafficlight: Boolean = false
        var redLightStatus: Boolean = false
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        val p= sender as Player
        if (trafficlight) {
            trafficlight = false
            redLightStatus = false
            p.sendMessage("§6[TrafficLights] §a신호등 기능이 꺼졌습니다!")
        } else if (!trafficlight) {
            trafficlight = true
            redLightStatus = true
            p.sendMessage("§6[TrafficLights] §a신호등 기능이 켜졌습니다!")
            // -----------------------------------------------------------
            Messages.redLightTitle(p)
        }
        return false
    }
}