package com.example.guessthenumber

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.guessthenumber.databinding.FragmentResultBinding


class ResultFragment : Fragment() {

    private lateinit var media: MediaPlayer


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
            binding.textView5.text = "Hard Luck, " + args.name + " got a score of  " + args.score.toString() + " In " + args.diff + " Game Mode in Guess The Number Game CSC-388 Edition."+ "  Try Again Later."
            val txtcolor = Color.rgb(255,0,0)
            binding.textView5.setTextColor(txtcolor)
            media = MediaPlayer.create(context, R.raw.fail)
            media.start()
        }
        else {
            binding.textView5.text = "Congratulations, " + args.name + " got a score of " + args.score.toString() + " in the " + args.diff + " Game Mode in Guess The Number Game CSC-388 Edition."
            val txtcolor = Color.rgb(0,128,0)
            binding.textView5.setTextColor(txtcolor)
            media = MediaPlayer.create(context, R.raw.clapping)
            media.start()

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

    override fun onStop() {
        super.onStop()
        this.media.stop()

    }


}

