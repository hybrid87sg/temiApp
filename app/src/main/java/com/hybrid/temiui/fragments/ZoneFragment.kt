package com.hybrid.temiui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentZoneBinding
import com.robotemi.sdk.Robot


class ZoneFragment : Fragment(R.layout.fragment_zone) {

    private lateinit var binding: FragmentZoneBinding
    val robot = Robot.getInstance()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentZoneBinding.bind(view)



        binding.ivZoneA.setOnClickListener {
            binding.gridZoneB.visibility = View.GONE
            binding.gridZoneA.visibility = View.VISIBLE
        }

        binding.ivZoneB.setOnClickListener {
            binding.gridZoneB.visibility = View.VISIBLE
            binding.gridZoneA.visibility = View.GONE
        }
        binding.ivZoneB.setOnClickListener {
            binding.gridZoneB.visibility = View.VISIBLE
            binding.gridZoneA.visibility = View.GONE
        }
        binding.ivZoneB.setOnClickListener {
            binding.gridZoneB.visibility = View.VISIBLE
            binding.gridZoneA.visibility = View.GONE
        }
        binding.ivZoneB.setOnClickListener {
            binding.gridZoneB.visibility = View.VISIBLE
            binding.gridZoneA.visibility = View.GONE
        }
        binding.ivZoneB.setOnClickListener {
            binding.gridZoneB.visibility = View.VISIBLE
            binding.gridZoneA.visibility = View.GONE
        }
        binding.ivZoneB.setOnClickListener {
            binding.gridZoneB.visibility = View.VISIBLE
            binding.gridZoneA.visibility = View.GONE
        }

        binding.a1.setOnClickListener {
            robot.goTo("a1")
        }
    }


}
