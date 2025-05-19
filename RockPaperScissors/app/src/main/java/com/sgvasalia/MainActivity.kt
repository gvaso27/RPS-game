package com.sgvasalia

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible

import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var startText: TextView? = null

    private var computersScore: TextView? = null

    private var playersScore: TextView? = null

    private var computersTurn: ImageView? = null

    private var playersTurn: ImageView? = null

    private var rockButton: Button? = null

    private var paperButton: Button? = null

    private var scissorsButton: Button? = null

    private var compMoveIdentifier: Int = 0

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        settingVariables()

        move()
    }



    private fun settingVariables(){
        startText = findViewById(R.id.start_text)

        computersScore = findViewById(R.id.computer_score)

        playersScore = findViewById(R.id.player_score)

        computersTurn = findViewById(R.id.computer_turn)

        playersTurn = findViewById(R.id.player_turn)

        rockButton = findViewById(R.id.rock)

        paperButton = findViewById(R.id.paper)

        scissorsButton = findViewById(R.id.scissors)
    }

    private fun move() {
        rockButton?.setOnClickListener {
            startText?.isVisible = false
            computersMove()
            playersTurn?.setImageResource(R.drawable.rock)
            if (getComputerMove() == "Scissors"){
                var score = playersScore?.text.toString().toInt()
                score+=1
                playersScore?.text = score.toString()
                playersScore?.setTextColor(getColor(R.color.green))
                computersScore?.setTextColor(getColor(R.color.black))
            }
            if (getComputerMove() == "Paper"){
                var score = computersScore?.text.toString().toInt()
                score+=1
                computersScore?.text = score.toString()
                computersScore?.setTextColor(getColor(R.color.green))
                playersScore?.setTextColor(getColor(R.color.black))
            }
            if (getComputerMove() == "Rock"){
                playersScore?.setTextColor(getColor(R.color.yellow))
                computersScore?.setTextColor(getColor(R.color.yellow))
            }
        }
        paperButton?.setOnClickListener {
            startText?.isVisible = false
            computersMove()
            playersTurn?.setImageResource(R.drawable.paper)
            if (getComputerMove() == "Rock"){
                var score = playersScore?.text.toString().toInt()
                score+=1
                playersScore?.text = score.toString()
                playersScore?.setTextColor(getColor(R.color.green))
                computersScore?.setTextColor(getColor(R.color.black))
            }
            if (getComputerMove() == "Scissors"){
                var score = computersScore?.text.toString().toInt()
                score+=1
                computersScore?.text = score.toString()
                computersScore?.setTextColor(getColor(R.color.green))
                playersScore?.setTextColor(getColor(R.color.black))
            }
            if (getComputerMove() == "Paper"){
                playersScore?.setTextColor(getColor(R.color.yellow))
                computersScore?.setTextColor(getColor(R.color.yellow))
            }
        }
        scissorsButton?.setOnClickListener {
            startText?.isVisible = false
            computersMove()
            playersTurn?.setImageResource(R.drawable.scissors)
            if (getComputerMove() == "Paper"){
                var score = playersScore?.text.toString().toInt()
                score+=1
                playersScore?.text = score.toString()
                playersScore?.setTextColor(getColor(R.color.green))
                computersScore?.setTextColor(getColor(R.color.black))
            }
            if (getComputerMove() == "Rock"){
                var score = computersScore?.text.toString().toInt()
                score+=1
                computersScore?.text = score.toString()
                computersScore?.setTextColor(getColor(R.color.green))
                playersScore?.setTextColor(getColor(R.color.black))
            }
            if (getComputerMove() == "Scissors"){
                playersScore?.setTextColor(getColor(R.color.yellow))
                computersScore?.setTextColor(getColor(R.color.yellow))
            }
        }
    }

    private fun computersMove() {
        val choices = listOf(R.drawable.rock, R.drawable.paper, R.drawable.scissors)
        compMoveIdentifier = choices[Random.nextInt(choices.size)]
        computersTurn?.setImageResource(compMoveIdentifier)
    }

    private fun getComputerMove(): String {
        return when (compMoveIdentifier) {
            R.drawable.rock -> "Rock"
            R.drawable.paper -> "Paper"
            R.drawable.scissors -> "Scissors"
            else -> "Unknown"
        }
    }

}