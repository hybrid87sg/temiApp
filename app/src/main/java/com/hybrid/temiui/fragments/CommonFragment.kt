package com.hybrid.temiui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentCommonBinding
import com.robotemi.sdk.Robot


class CommonFragment : Fragment(R.layout.fragment_common) {

    private lateinit var binding : FragmentCommonBinding
    private val robot = Robot.getInstance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCommonBinding.bind(view)

        binding.ibHaylee.setOnClickListener {
            robot.goTo("haylee")
        }
        binding.ibInfo.setOnClickListener {
            robot.goTo("home base")
        }


    }
}