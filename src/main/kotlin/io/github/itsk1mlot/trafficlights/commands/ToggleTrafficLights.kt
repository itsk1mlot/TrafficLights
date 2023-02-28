package io.github.itsk1mlot.trafficlights.commands

import org.bukkit.GameRule
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

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
            //p.sendMessage(I18n.t("system_toggle_off"))
            p.world.setGameRule(GameRule.SHOW_DEATH_MESSAGES, true)
            p.sendMessage("§6신호등 시스템이 §c꺼졌습니다.")
        } else if (!trafficlight) {
            trafficlight = true
            redLightStatus = false
            //p.sendMessage(I18n.t("system_toggle_on"))
            p.world.setGameRule(GameRule.SHOW_DEATH_MESSAGES, false)
            p.sendMessage("§6신호등 시스템이 §a켜졌습니다.")
        }
        return false
    }
}