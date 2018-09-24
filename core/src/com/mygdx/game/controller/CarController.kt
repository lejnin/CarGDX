package com.mygdx.game.controller

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Polygon
import com.mygdx.game.view.GameScreen

class CarController(carBounds : Polygon) {

    private var carBounds: Polygon = carBounds
    var speed = 0F
    var rotationSpeed = 20F
    val velocity = 5F
    val speedMax = 10F

    fun handle() {
        when {
            Gdx.input.isKeyPressed(Input.Keys.UP) -> speed += velocity * GameScreen.deltaCff
            Gdx.input.isKeyPressed(Input.Keys.DOWN) -> speed -= velocity * GameScreen.deltaCff
            else -> speed = downSpeed()
        }

        when {
            speed > speedMax -> speed = speedMax
            speed < -speedMax -> speed = -speedMax
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            carBounds.rotate(rotationSpeed * speed * GameScreen.deltaCff)
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            carBounds.rotate(-rotationSpeed * speed * GameScreen.deltaCff)
        }



        carBounds.setPosition(carBounds.x + MathUtils.cosDeg(carBounds.rotation + 90) * speed * GameScreen.deltaCff,
                carBounds.y + MathUtils.sinDeg(carBounds.rotation + 90) * speed * GameScreen.deltaCff)
    }

    private fun downSpeed(): Float {
        if(speed < 0 && (speed+velocity * GameScreen.deltaCff) < 0){
            return speed + velocity * GameScreen.deltaCff
        } else if (speed > 0 && (speed + velocity * GameScreen.deltaCff) > 0) {
            return speed - velocity * GameScreen.deltaCff
        } else {
            return 0F
        }
    }

}