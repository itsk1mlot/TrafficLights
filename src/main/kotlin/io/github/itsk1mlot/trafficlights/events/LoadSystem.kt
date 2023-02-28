package io.github.itsk1mlot.trafficlights.events

import org.bukkit.scheduler.BukkitRunnable
import io.github.itsk1mlot.trafficlights.Main
import io.github.itsk1mlot.trafficlights.commands.ToggleTrafficLights
import io.github.itsk1mlot.trafficlights.objects.Messages
import java.util.*
import kotlin.random.Random

object LoadSystem {
    class Runnable: BukkitRunnable() {
        override fun run() {
            if (ToggleTrafficLights.trafficlight) {
                val random = Random.nextBoolean()
                //println("랜덤한 값은 다음과 같습니다: ${random}")
                if (!random) {
                    val timer: Timer = Timer()
                    Messages.warnRedLight(3)
                    timer.schedule(StartTimer(), 1000)
                }
            }/* else {
                println("시스템은 꺼져있지만 반복은 작동했습니다! (추후제거)")
            }*/
        }
    }
    fun main() {
        Runnable().runTaskTimer(Main.instance, 1200, 1200)
    }
}

class StartTimer : TimerTask() {
    @Override
    override fun run() {
        Messages.warnRedLight(2)
        val timer2: Timer = Timer()
        timer2.schedule(StartTimer2(), 1000)
    }
}

class StartTimer2 : TimerTask() {
    @Override
    override fun run() {
        Messages.warnRedLight(1)
        val timer3: Timer = Timer()
        timer3.schedule(StartTimer3(), 1000)
    }
}

class StartTimer3 : TimerTask() {
    @Override
    override fun run() {
        ToggleTrafficLights.redLightStatus = true
        Messages.redLightTitle()
        val timer4: Timer = Timer()
        timer4.schedule(StartTimer4(), 5000)
    }
}

class StartTimer4: TimerTask() {
    @Override
    override fun run() {
        ToggleTrafficLights.redLightStatus = false
        Messages.greenLightTitle()
    }
}
