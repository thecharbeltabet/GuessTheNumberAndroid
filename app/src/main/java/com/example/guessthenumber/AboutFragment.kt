package com.example.guessthenumber

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.guessthenumber.databinding.FragmentAboutBinding
import com.example.guessthenumber.databinding.FragmentGameBinding

class AboutFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_about, container, false)
        val binding: FragmentAboutBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_about, container, false)

        binding.Gobutton.setOnClickListener {

            val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ndu.edu.lb/academics/faculty-of-natural-applied-sciences/computer-science/computer-science"))
            startActivity(webIntent)
        }


        return binding.root
    }


}