package com.mygdx.game.utils

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.g2d.TextureAtlas

class Assets(private val manager: AssetManager = AssetManager()) {

    init {

        manager.load("atlas1.atlas", TextureAtlas::class.java)
        manager.finishLoading()
    }

    fun getManager(): AssetManager {
        return manager
    }

    fun dispose() {
         manager.dispose()
    }

}