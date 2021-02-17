package com.hybrid.temiui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentZoneBinding
import com.hybrid.temiui.fragments.adapter.ViewPagerAdapter
import com.robotemi.sdk.Robot

class ZoneFragment : Fragment(R.layout.fragment_zone) {

    private lateinit var binding: FragmentZoneBinding
    private val robot = Robot.getInstance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentZoneBinding.bind(view)
/*
        val gridAFragment = GridAFragment()
        val gridBFragment = GridBFragment()
        val gridCFragment = GridCFragment()
        val gridDFragment = GridDFragment()
        val gridEFragment = GridEFragment()
        val gridFFragment = GridFFragment()
        val gridGFragment = GridGFragment()
        val commonFragment = CommonFragment()

        childFragmentManager.beginTransaction().apply {
            replace(R.id.fragment, commonFragment)
            commit()
        }*/

        setupTabs()
    }

    private fun setupTabs(){
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(CommonFragment(), getString(R.string.popular))
        adapter.addFragment(GridAFragment(),"Zone A")
        adapter.addFragment(GridBFragment(),"Zone B")
        adapter.addFragment(GridCFragment(),"Zone C")
        adapter.addFragment(GridDFragment(),"Zone D")
        adapter.addFragment(GridEFragment(),"Zone E")
        adapter.addFragment(GridFFragment(),"Zone F")
        adapter.addFragment(GridGFragment(),"Zone G")
        binding.viewPager.adapter = adapter
        binding.zoneTab.setupWithViewPager(binding.viewPager)
        binding.zoneTab.getTabAt(0)?.text = getString(R.string.popular)
        binding.zoneTab.getTabAt(1)?.text = getString(R.string.zoneA)
        binding.zoneTab.getTabAt(2)?.text = getString(R.string.zoneB)
        binding.zoneTab.getTabAt(3)?.text = getString(R.string.zoneC)
        binding.zoneTab.getTabAt(4)?.text = getString(R.string.zoneD)
        binding.zoneTab.getTabAt(5)?.text = getString(R.string.zoneE)
        binding.zoneTab.getTabAt(6)?.text = getString(R.string.zoneF)
        binding.zoneTab.getTabAt(7)?.text = getString(R.string.zoneG)

    }


}







