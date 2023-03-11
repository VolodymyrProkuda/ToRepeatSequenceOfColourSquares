package com.trsocs.torepeatsequenceofcoloursquares

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.trsocs.torepeatsequenceofcoloursquares.databinding.ActivityMainBinding

import java.util.*



class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val eightSquareColors = listOf<Int>(R.drawable.four_color_cquare_game_1, R.drawable.four_color_cquare_game_2,
        R.drawable.four_color_cquare_game_3,R.drawable.four_color_cquare_game_4)
    val eightSquareNunbers = mutableListOf<Int>(0,0,0,0)
    val eightSquareNunbersPlayer = mutableListOf<Int>(0,0,0,0)
    var win = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonTimerGo.setOnClickListener { onTimerGo() }
        binding.imageViewSquare4.setOnClickListener { playerSquaresDraw(0) }
        binding.imageViewSquare5.setOnClickListener { playerSquaresDraw(1) }
        binding.imageViewSquare6.setOnClickListener { playerSquaresDraw(2) }
        binding.imageViewSquare7.setOnClickListener { playerSquaresDraw(3) }

    }
    fun onTimerGo(){
        win = false

        object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                if (win == false)
                binding.textViewEightSquaresResult.setText("seconds remaining: " + millisUntilFinished / 1000)

            }
            override fun onFinish() {
                if (win == false)
                binding.textViewEightSquaresResult.setText("lose!")
            }
        }.start()

        for(i in 0..3) {eightSquareNunbers[i] = (0..3).random()}

        binding.imageViewSquare1.setImageResource(eightSquareColors[eightSquareNunbers[0]])
        binding.imageViewSquare.setImageResource(eightSquareColors[eightSquareNunbers[1]])
        binding.imageViewSquare2.setImageResource(eightSquareColors[eightSquareNunbers[2]])
        binding.imageViewSquare3.setImageResource(eightSquareColors[eightSquareNunbers[3]])

    }
    fun playerSquaresDraw(ii:Int){
        eightSquareNunbersPlayer[ii] +=1
        if (eightSquareNunbersPlayer[ii]==4) eightSquareNunbersPlayer[ii]=0
        binding.imageViewSquare4.setImageResource(eightSquareColors[eightSquareNunbersPlayer[0]])
        binding.imageViewSquare5.setImageResource(eightSquareColors[eightSquareNunbersPlayer[1]])
        binding.imageViewSquare6.setImageResource(eightSquareColors[eightSquareNunbersPlayer[2]])
        binding.imageViewSquare7.setImageResource(eightSquareColors[eightSquareNunbersPlayer[3]])
        if ((binding.textViewEightSquaresResult.text != "lose!") &&
            (eightSquareNunbers[0]==eightSquareNunbersPlayer[0]) &&
                (eightSquareNunbers[1]==eightSquareNunbersPlayer[1]) &&
                (eightSquareNunbers[2]==eightSquareNunbersPlayer[2]) &&
                (eightSquareNunbers[3]==eightSquareNunbersPlayer[3]))
                {
            binding.textViewEightSquaresResult.text = "WIN!!!"
            win = true
        }


    }
}