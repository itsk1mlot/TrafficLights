package io.github.itsk1mlot.trafficlights.commands

import io.github.itsk1mlot.trafficlights.i18n.I18n
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
            p.sendMessage(I18n.t("system_toggle_off"))
        } else if (!trafficlight) {
            trafficlight = true
            redLightStatus = false
            p.sendMessage(I18n.t("system_toggle_on"))
        }
        return false
    }
}