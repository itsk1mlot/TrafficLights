package io.github.itsk1mlot.trafficlights.objects

import io.github.itsk1mlot.trafficlights.i18n.I18n
import net.kyori.adventure.text.Component
import net.kyori.adventure.title.TitlePart
import org.bukkit.entity.Player

object Messages {

    fun redLightTitle(p: Player) {
        p.sendTitlePart(TitlePart.TITLE, Component.text(I18n.t("red_light_title")))
        p.sendTitlePart(TitlePart.SUBTITLE, Component.text(I18n.t("red_light_description")))
    }
    fun greenLightTitle(p: Player) {
        p.sendTitlePart(TitlePart.TITLE, Component.text(I18n.t("green_light_title")))
        p.sendTitlePart(TitlePart.SUBTITLE, Component.text(I18n.t("green_light_description")))
    }
}