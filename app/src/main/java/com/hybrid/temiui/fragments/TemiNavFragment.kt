package com.hybrid.temiui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentTemiNavBinding
import com.robotemi.sdk.Robot
import com.robotemi.sdk.TtsRequest


class TemiNavFragment : DialogFragment(R.layout.fragment_temi_nav) {
private lateinit var binding: FragmentTemiNavBinding
    val robot = Robot.getInstance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTemiNavBinding.bind(view)


        binding.tvSubText.text = getText(R.string.nil)

        binding.tvClose.setOnClickListener {
            dismiss()
        }

        binding.btnFollow.setOnClickListener {
            robot.beWithMe()
            robot.speak(TtsRequest.create("Where do you want me to follow you to?",false))
            binding.tvSubText.text = getText(R.string.follow)
        }

        binding.btnChange.setOnClickListener {
            robot.stopMovement()
            robot.speak(TtsRequest.create("Changing destination.",false))
            dismiss()
        }

        binding.btnPause.setOnClickListener {
            robot.stopMovement()
            robot.speak(TtsRequest.create("Stopping movement!",false))
            binding.tvSubText.text = getText(R.string.pausenav)
        }

    }
}