package com.edesoftech.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }

        // When app starts, roll the dice
        rollDice()
    }

    /**
    * Roll the dice and update the screen with the result.
    */
    private fun rollDice() {
        val diceOne = Dice(6)
        val diceRollOne = diceOne.roll()
        val diceImageOne: ImageView = findViewById(R.id.imageView)

        val diceTwo = Dice(6)
        val diceRollTwo = diceTwo.roll()
        val diceImageTwo: ImageView = findViewById(R.id.imageView2)

        val drawableResourceOne = when (diceRollOne) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImageOne.setImageResource(drawableResourceOne)

        val drawableResourceTwo = when (diceRollTwo) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImageTwo.setImageResource(drawableResourceTwo)

        diceImageOne.contentDescription = diceRollOne.toString()
        diceImageTwo.contentDescription = diceRollTwo.toString()
    }
}

class Dice(private val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}