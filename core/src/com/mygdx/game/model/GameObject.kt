package com.mygdx.game.model

import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Polygon

abstract class GameObject(textureRegion: TextureRegion, x: Float, y: Float, width: Float, height: Float) {

    var bounds: Polygon
    var gameObject: Sprite

    init {

        gameObject = Sprite(textureRegion)
        gameObject.setSize(width, height)
        gameObject.setOrigin(width / 2f, height / 2f)
        gameObject.setPosition(x, y)

        bounds = Polygon(floatArrayOf(0f, 0f, width, 0f, width, height, 0f, height))
        bounds.setPosition(x, y)
        bounds.setOrigin(width / 2f, height / 2f)

    }

    open fun draw(batch: SpriteBatch) {
        gameObject.setPosition(bounds.x, bounds.y)
        gameObject.rotation = bounds.rotation
        gameObject.draw(batch)
    }

}