package io.github.itsk1mlot.trafficlights.objects

import net.kyori.adventure.text.Component
import net.kyori.adventure.title.TitlePart
import org.bukkit.Bukkit
import org.bukkit.Sound

object Messages {

    fun redLightTitle() {
        Bukkit.getOnlinePlayers().forEach { it.sendTitlePart(TitlePart.TITLE, Component.text("§4빨간불입니다!")) }
        Bukkit.getOnlinePlayers().forEach { it.sendTitlePart(TitlePart.SUBTITLE, Component.text("§6지금 움직이면 §c사망합니다!")) }
        Bukkit.getOnlinePlayers().forEach { it.playSound(it.location, Sound.BLOCK_NOTE_BLOCK_PLING, 100.0f, 2.0f) }
        /*
        p.sendTitlePart(TitlePart.TITLE, Component.text(I18n.t("red_light_title")))
        p.sendTitlePart(TitlePart.TITLE, Component.text("red_light_title"))
        p.sendTitlePart(TitlePart.SUBTITLE, Component.text(I18n.t("red_light_description")))
        p.sendTitlePart(TitlePart.SUBTITLE, Component.text("red_light_description"))
        */
    }
    fun greenLightTitle() {
        Bukkit.getOnlinePlayers().forEach { it.sendTitlePart(TitlePart.TITLE, Component.text("§a초록불입니다!")) }
        Bukkit.getOnlinePlayers().forEach { it.sendTitlePart(TitlePart.SUBTITLE, Component.text("§6이제 다시 §a움직일 수 있습니다.")) }
        Bukkit.getOnlinePlayers().forEach { it.playSound(it.location, Sound.ENTITY_PLAYER_LEVELUP, 100.0f, 1.0f) }
        /*
        p.sendTitlePart(TitlePart.TITLE, Component.text(I18n.t("green_light_title")))
        p.sendTitlePart(TitlePart.TITLE, Component.text("green_light_title"))
        p.sendTitlePart(TitlePart.SUBTITLE, Component.text(I18n.t("green_light_description")))
        p.sendTitlePart(TitlePart.SUBTITLE, Component.text("green_light_description"))
        */
    }

    fun warnRedLight(t: Int) {
        Bukkit.getOnlinePlayers().forEach { it.sendTitlePart(TitlePart.TITLE, Component.text("§c주의하세요!")) }
        Bukkit.getOnlinePlayers().forEach { it.sendTitlePart(TitlePart.SUBTITLE, Component.text("§e${t}초 §c후 빨간불로 바뀝니다!")) }
        Bukkit.getOnlinePlayers().forEach { it.playSound(it.location, Sound.BLOCK_NOTE_BLOCK_PLING, 100.0f, 1.0f) }
        /*
        p.sendTitlePart(TitlePart.TITLE, Component.text("§c주의하세요!"))
        p.sendTitlePart(TitlePart.SUBTITLE, Component.text("§e${t}초 §c후 빨간불로 바뀝니다!"))
        */
    }
}