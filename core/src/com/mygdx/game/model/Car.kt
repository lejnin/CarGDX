package com.mygdx.game.model

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.mygdx.game.controller.CarController

class Car(textureRegion: TextureRegion, x: Float, y: Float, width: Float, height: Float) : GameObject(textureRegion, x, y, width, height) {
    private val carController : CarController = CarController(bounds)

    override fun draw(batch: SpriteBatch) {
        super.draw(batch)
        carController.handle()
    }
}