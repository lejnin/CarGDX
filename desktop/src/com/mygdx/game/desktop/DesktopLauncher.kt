package com.mygdx.game.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.mygdx.game.Main

object DesktopLauncher {
    @JvmStatic
    fun main(arg: Array<String>) {
        val config = LwjglApplicationConfiguration()

        config.width = 900
        config.height = 450
        //config.fullscreen = true;
        config.foregroundFPS = 0
        config.vSyncEnabled = false

        LwjglApplication(Main(), config)
    }
}
