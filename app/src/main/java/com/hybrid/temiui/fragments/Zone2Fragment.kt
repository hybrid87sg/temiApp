package com.hybrid.temiui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentZone2Binding


class Zone2Fragment : Fragment(R.layout.fragment_zone2) {

    private lateinit var binding: FragmentZone2Binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentZone2Binding.bind(view)

        val gridA = GridAFragment()
        val gridB = GridBFragment()
        val gridC = GridCFragment()
        val gridD = GridDFragment()
        val gridE = GridEFragment()
        val gridF = GridFFragment()
        val gridG = GridGFragment()
        val gridBrands = BrandsFragment()
        val gridUtils = UtilsFragment()

        binding.btn2ZoneA.setOnClickListener {
            setCurrentFragment(gridA)
            binding.zoneTitle.text = getText(R.string.zoneA)
        }
        binding.btn2ZoneB.setOnClickListener {
            setCurrentFragment(gridB)
            binding.zoneTitle.text = getText(R.string.zoneB)
        }
        binding.btn2ZoneC.setOnClickListener {
            setCurrentFragment(gridC)
            binding.zoneTitle.text = getText(R.string.zoneC)
        }
        binding.btn2ZoneD.setOnClickListener {
            setCurrentFragment(gridD)
            binding.zoneTitle.text = getText(R.string.zoneD)
        }
        binding.btn2ZoneE.setOnClickListener {
            setCurrentFragment(gridE)
            binding.zoneTitle.text = getText(R.string.zoneE)
        }
        binding.btn2ZoneF.setOnClickListener {
            setCurrentFragment(gridF)
            binding.zoneTitle.text = getText(R.string.zoneF)
        }
        binding.btn2ZoneG.setOnClickListener {
            setCurrentFragment(gridG)
            binding.zoneTitle.text = getText(R.string.zoneG)
        }
        binding.btn2ZoneBrands.setOnClickListener {
            setCurrentFragment(gridBrands)
            binding.zoneTitle.text = getText(R.string.brands)
        }
        binding.btn2ZoneUtils.setOnClickListener {
            setCurrentFragment(gridUtils)
            binding.zoneTitle.text = getText(R.string.utils)
        }


    }

    private fun setCurrentFragment(fragment: Fragment) =
        childFragmentManager.beginTransaction().apply {
            replace(R.id.gridFrame, fragment)
            commit()
        }


}