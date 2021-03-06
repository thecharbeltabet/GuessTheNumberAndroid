package com.example.guessthenumber

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.PorterDuff
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.guessthenumber.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    private var rand: Int = 0
    private var score: Int = 5
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_game, container, false)


        val binding: FragmentGameBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
        var args = GameFragmentArgs.fromBundle(requireArguments())
        binding.YourName2.text = args.name + "'s score : " + score.toString()


        mediaPlayer = MediaPlayer.create(context, R.raw.got)
        mediaPlayer.isLooping = true
        mediaPlayer.start()

        var diff = args.difficulty
        binding.Difficulty.text = "Game Difficulty: " + diff



        fun goToNext() {
            view?.findNavController()?.navigate(GameFragmentDirections.actionGameFragmentToResultFragment(score,args.name,args.difficulty))
        }


        fun showDefaultDialog() {
            val alertDialog = AlertDialog.Builder(context)
            alertDialog.apply {
                setTitle("Game Over ! Better Luck Next time")
            }.create().show()
        }

        fun generatedRand() {
            if (diff == "Easy") {
                rand = (1..5).random()
                binding.textView.text = "Your Guess should be between 1 and 5 inclusive"


            } else if (diff == "Medium") {

                rand = (1..15).random()
                binding.textView.text = "Your Guess should be between 1 and 15 inclusive"

            } else if (diff == "Hard") {
                rand = (1..25).random()
                binding.textView.text = "Your Guess should be between 1 and 25 inclusive"
            }


        }




        fun checkScore(sc: Int) {

            if (sc < 0 || sc == 0) {

                showDefaultDialog()
                score = 0

                goToNext()

            }}

            generatedRand()
            binding.CheckBtn.setOnClickListener { view: View ->
                var guess = binding.NumberGuess.text.toString()

                if (guess == "") {

                    val text = "You should enter a number"
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(context, text, duration)
                    toast.setGravity(Gravity.TOP or Gravity.LEFT, 350, 2150)
                    toast.show()

                } else {
                    var guessed = Integer.parseInt(guess)
                    if (guessed == rand) {
                        val imageColor = Color.rgb(0,128,0)
                        binding.imageView2.setColorFilter(imageColor,PorterDuff.Mode.SRC_ATOP)
                        val text = "You Guessed it right"
                        val duration = Toast.LENGTH_SHORT
                        val toast = Toast.makeText(context, text, duration)
                        toast.setGravity(Gravity.TOP or Gravity.LEFT, 400, 2150)
                        toast.show()

                        score += 5
                        checkScore(score)
                        binding.YourName2.text = args.name + "'s score : " + score.toString()
                        generatedRand()
                    } else {
                        val imageColor = Color.rgb(255,0,0)
                        binding.imageView2.setColorFilter(imageColor,PorterDuff.Mode.SRC_ATOP)
                        val text = "You Guessed it wrong!"
                        val duration = Toast.LENGTH_SHORT
                        val toast = Toast.makeText(context, text, duration)
                        toast.setGravity(Gravity.TOP or Gravity.LEFT, 400, 2150)
                        toast.show()

                        score -= 1
                        checkScore(score)
                        binding.YourName2.text = args.name + "'s score : " + score.toString()



                    }
                }


            }

        binding.EndButton.setOnClickListener {


            goToNext()
        }



            setHasOptionsMenu(true)
            return binding.root
        }


        override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
            super.onCreateOptionsMenu(menu, inflater)
            inflater?.inflate(R.menu.overflow_menu, menu)
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            return NavigationUI.onNavDestinationSelected(item!!, requireView().findNavController())
                    || super.onOptionsItemSelected(item)
        }

    override fun onStop() {
        super.onStop()
        mediaPlayer.stop()
    }





}
