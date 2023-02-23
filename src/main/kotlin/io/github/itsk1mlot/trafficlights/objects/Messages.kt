package io.github.itsk1mlot.trafficlights.objects

import net.kyori.adventure.text.Component
import net.kyori.adventure.title.TitlePart
import org.bukkit.entity.Player

object Messages {

    fun redLightTitle(p: Player) {
        p.sendTitlePart(TitlePart.TITLE, Component.text("§c빨간불입니다!"))
        p.sendTitlePart(TitlePart.SUBTITLE, Component.text("§e지금 움직이면 §c사망합니다!"))
    }
    fun greenLightTitle(p: Player) {
        p.sendTitlePart(TitlePart.TITLE, Component.text("§a초록불입니다!"))
        p.sendTitlePart(TitlePart.SUBTITLE, Component.text("§e이제 움직여도 §a괜찮습니다!"))
    }
}