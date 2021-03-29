package com.hybrid.temiui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hybrid.temiui.R
import com.robotemi.sdk.Robot
import com.robotemi.sdk.TtsRequest


class TemiNavFragment : DialogFragment() {

    val robot = Robot.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootview: View = inflater.inflate(R.layout.fragment_temi_nav, container, false)

        val tvSubText = rootview.findViewById<TextView>(R.id.tvSubText)
        val btnPause = rootview.findViewById<Button>(R.id.btnPause)
        val btnChange = rootview.findViewById<Button>(R.id.btnChange)
        val btnFollow = rootview.findViewById<Button>(R.id.btnFollow)

        tvSubText.text = getText(R.string.nil)

        btnFollow.setOnClickListener {
            robot.beWithMe()
            robot.speak(TtsRequest.create("Where do you want me to follow you to?",false))
            tvSubText.text = getText(R.string.follow)
        }

        btnChange.setOnClickListener {
            robot.stopMovement()
            robot.speak(TtsRequest.create("Changing destination.",false))
            dismiss()
        }

        btnPause.setOnClickListener {
            robot.stopMovement()
            robot.speak(TtsRequest.create("Stopping movement!",false))
            tvSubText.text = getText(R.string.pausenav)
        }

        return rootview
    }
}