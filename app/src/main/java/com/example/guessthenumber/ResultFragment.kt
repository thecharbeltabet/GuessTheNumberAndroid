package com.example.guessthenumber

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
            binding.textView5.text = "Hard Luck " + args.name + " ! In " + args.diff + " Game Mode you got a Score of: " + args.score.toString() + "  Try Again Later"
        }
        else
        {
            binding.textView5.text = "Congratulations " + args.name + " ! In " + args.diff + " Game Mode you got a Score of: " + args.score.toString()
        }
        return binding.root
    }


}

