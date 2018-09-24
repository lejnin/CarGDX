package com.mygdx.game

import com.badlogic.gdx.Game
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.mygdx.game.utils.Assets
import com.mygdx.game.view.GameScreen

class Main : Game() {

    private lateinit var gameScreen: Screen
    private lateinit var assets: Assets

    override fun create() {
        assets = Assets()
        gameScreen = GameScreen()
        (gameScreen as GameScreen).setTextureAtlas(assets.getManager().get("atlas1.atlas", TextureAtlas::class.java))
        setScreen(gameScreen)
    }

    override fun dispose() {
        super.dispose()
        gameScreen.dispose()
        assets.dispose()
    }

}
