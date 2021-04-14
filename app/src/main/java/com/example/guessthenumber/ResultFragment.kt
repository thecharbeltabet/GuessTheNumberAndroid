package com.example.guessthenumber

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.guessthenumber.databinding.FragmentResultBinding


class ResultFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_result, container, false)
        var args = ResultFragmentArgs.fromBundle(requireArguments())
        val binding : FragmentResultBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_result, container, false)

        if (args.score == 0)
        {
            binding.textView5.text = "Hard Luck, " + args.name + " got a score of  " + args.score.toString() + " In " + args.diff + " Game Mode."+ "  Try Again Later."
        }
        else
        {
            binding.textView5.text = "Congratulations, " + args.name + " got a score of  " + args.score.toString() + " In " + args.diff + " Game Mode."
        }

            val message = binding.textView5.text.toString() + " Can you beat it ? Come have a try "

            binding.ShareBtn.setOnClickListener {
                /*Intent(Intent.ACTION_SEND).apply{
                    type = "text/plain"
                    putExtra(MY_MESSAGE,"This is an automated message sent by guess the number game")
                }.also {
                    startActivity(it)
                }*/  // Didn't work

                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT,message)
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }





        return binding.root
    }


}

