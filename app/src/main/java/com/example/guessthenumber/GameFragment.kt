package com.example.guessthenumber

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.guessthenumber.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    private  var rand: Int = 0
    private var score: Int = 5
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_game, container, false)
        val binding: FragmentGameBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_game,container,false)
        var args = GameFragmentArgs.fromBundle(requireArguments())
        binding.YourName2.text = args.name
        var diff = args.difficulty
        binding.Difficulty.text = diff
        binding.ScoreView.text = score.toString()






        if (diff == "easy")
        {
            rand = (1..5).random()


        }
        else if (diff == "medium")
        {

             rand = (1..15).random()
        }
        else if (diff == "hard")
        {
             rand = (1..25).random()
        }

      /*  fun CheckScore(score : Int)
        {

            if (score == 0)
            {

            }
        }
*/


        binding.CheckBtn.setOnClickListener { view: View ->
            var guess = binding.NumberGuess.text.toString()
            if(guess == "") {
                val text = "You should enter a number"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(context, text, duration).show()

            }
            else {
                var guessed = Integer.parseInt(guess)
                if (guessed == rand) {
                    val text = "You Guessed it right"
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(context, text, duration).show()
                    score += 5
                    binding.ScoreView.text = score.toString()
                } else {
                    val text = "You Guessed it wrong $guessed"
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(context, text, duration).show()
                    score -=1
                    binding.ScoreView.text = score.toString()
                }
            }



        }





        setHasOptionsMenu(true)
        return binding.root
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
       super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
               return NavigationUI.onNavDestinationSelected(item!!,requireView().findNavController())
               || super.onOptionsItemSelected(item)
    }
}
