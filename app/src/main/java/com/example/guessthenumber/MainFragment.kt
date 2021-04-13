package com.example.guessthenumber

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.guessthenumber.databinding.ActivityMainBinding
import com.example.guessthenumber.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_main, container, false)
        val binding: FragmentMainBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false)
        binding.StartButton.setOnClickListener { view: View ->
            val checkID = binding.RadioGroup.checkedRadioButtonId

            if(-1 != checkID)
            {
                when(checkID)
                {
                    R.id.radioButtonEasy -> view.findNavController().navigate(MainFragmentDirections.actionMainFragmentToGameFragment(binding.YourName.text.toString(),"easy"))
                    R.id.radioButtonMedium -> view.findNavController().navigate(MainFragmentDirections.actionMainFragmentToGameFragment(binding.YourName.text.toString(),"medium"))
                    R.id.radioButtonHard -> view.findNavController().navigate(MainFragmentDirections.actionMainFragmentToGameFragment(binding.YourName.text.toString(),"hard"))
                }
            }

        }



        return binding.root
    }



}