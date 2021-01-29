package com.hybrid.temiui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.hybrid.temiui.MapActivity
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentZoneBinding


class ZoneFragment : Fragment(R.layout.fragment_zone) {

    private lateinit var binding: FragmentZoneBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentZoneBinding.bind(view)

        binding.zoneAButton.setOnClickListener {
            binding.gridZoneB.visibility = View.GONE
            binding.gridZoneA.visibility = View.VISIBLE
        }

        binding.zoneBButton.setOnClickListener {
            binding.gridZoneB.visibility = View.VISIBLE
            binding.gridZoneA.visibility = View.GONE
        }
    }



}
