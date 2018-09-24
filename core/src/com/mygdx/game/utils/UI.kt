package com.mygdx.game.utils

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.viewport.FitViewport

class UI {
    private val stage: Stage = Stage(FitViewport(800F, 600F))
    private var skin: Skin = Skin(Gdx.files.internal("skin.json"))
    private lateinit var label: Label

    init {
        //addLabelToStage()
    }

    private fun addLabelToStage() {
        label = Label("Hello!", skin.get("default", Label.LabelStyle::class.java))
        label.setAlignment(Align.center)
        label.setPosition(400F, 300F, Align.center)
        label.setFontScale(.3F)
        stage.addActor(label)
    }

    fun draw() {
        stage.viewport.update(Gdx.graphics.width, Gdx.graphics.height)
        stage.act()
        stage.draw()
    }

    fun dispose() {
        stage.dispose()
    }
}