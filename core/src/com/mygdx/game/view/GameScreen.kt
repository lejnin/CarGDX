package com.mygdx.game.view

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.mygdx.game.model.Car
import com.mygdx.game.utils.UI

class GameScreen : Screen {

    private lateinit var batch: SpriteBatch
    private lateinit var car: Car
    private lateinit var camera: OrthographicCamera
    private lateinit var textureAtlas: TextureAtlas
    private lateinit var ui : UI

    companion object {
        var deltaCff: Float = 0.toFloat()
    }

    fun setTextureAtlas(textureAtlas: TextureAtlas) {
        this.textureAtlas = textureAtlas
    }

    override fun hide() {

    }

    override fun show() {
        batch = SpriteBatch()
        car = Car(textureAtlas.findRegion("car"), 0F, 0F, 1F, 1F * 1.42F)
        ui = UI()
        resize(Gdx.graphics.width, Gdx.graphics.height)
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(0F, 5F, 0F, 1F)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        Gdx.gl.glViewport(0, 0, Gdx.graphics.width, Gdx.graphics.height)

        deltaCff = delta

        batch.projectionMatrix = camera.combined
        batch.begin()
        car.draw(batch)
        batch.end()

        ui.draw()
    }

    override fun pause() {

    }

    override fun resume() {

    }

    override fun resize(width: Int, height: Int) {
        val aspectRatio: Float = (height.toFloat() / width.toFloat())
        camera = OrthographicCamera(20F, 20F * aspectRatio)
        camera.zoom = 1F
        camera.update()
    }

    override fun dispose() {
        ui.dispose()
        batch.dispose()
    }

}