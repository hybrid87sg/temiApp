package com.hybrid.temiui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentZoneBinding
import com.robotemi.sdk.Robot


class ZoneFragment : Fragment(R.layout.fragment_zone) {

    private lateinit var binding: FragmentZoneBinding
    private val robot = Robot.getInstance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentZoneBinding.bind(view)

        val gridAFragment = GridAFragment()
        val gridBFragment = GridBFragment()

        childFragmentManager.beginTransaction().apply {
            replace(R.id.fragment, gridAFragment)
            commit()
        }

        binding.btnZoneA.setOnClickListener {
            childFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, gridAFragment)
                commit()
            }
        }

        binding.btnZoneB.setOnClickListener {
            childFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, gridBFragment)
                commit()
            }
        }
    }
}







