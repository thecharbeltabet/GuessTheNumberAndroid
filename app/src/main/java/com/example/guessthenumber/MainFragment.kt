package com.example.guessthenumber

import android.media.MediaPlayer
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.guessthenumber.databinding.FragmentMainBinding


class MainFragment : Fragment() {




    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_main, container, false)
        val binding: FragmentMainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)





        binding.StartButton.setOnClickListener { view: View ->
            val checkID = binding.RadioGroup.checkedRadioButtonId





            if(-1 != checkID && binding.YourName.text.toString() != "")
            {

                when(checkID)
                {
                    R.id.radioButtonEasy -> view.findNavController().navigate(MainFragmentDirections.actionMainFragmentToGameFragment(binding.YourName.text.toString(), "Easy"))
                    R.id.radioButtonMedium -> view.findNavController().navigate(MainFragmentDirections.actionMainFragmentToGameFragment(binding.YourName.text.toString(), "Medium"))
                    R.id.radioButtonHard -> view.findNavController().navigate(MainFragmentDirections.actionMainFragmentToGameFragment(binding.YourName.text.toString(), "Hard"))
                }
            }
            else {
                val text = "Enter Your Name"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(context, text, duration)
                toast.setGravity(Gravity.TOP or Gravity.LEFT, 450, 2000)
                toast.show()
            }






        }



        return binding.root
    }




}