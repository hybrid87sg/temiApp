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
import com.robotemi.sdk.Robot

class ZoneFragment : Fragment(R.layout.fragment_zone) {

    private lateinit var binding: FragmentZoneBinding
    private val robot = Robot.getInstance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentZoneBinding.bind(view)

        val zoning = resources.getStringArray(R.array.Zoning)

        val spinner: Spinner = requireView().findViewById(R.id.zoneSpinner)
        val adapter =
            context?.let { ArrayAdapter(it, android.R.layout.simple_spinner_item, zoning) }
        spinner.adapter = adapter

        val arrayList = arrayListOf(
            getString(R.string.popular),
            getString(R.string.zoneA),
            getString(R.string.zoneB),
            getString(R.string.zoneC),
            getString(R.string.zoneD),
            getString(R.string.zoneE),
            getString(R.string.zoneF),
            getString(R.string.zoneG)
        )

        val gridArrayList = arrayListOf<Fragment>(
            GridAFragment(),
            GridBFragment(),
            GridCFragment(),
            GridGFragment()
        )

        binding.titleTop.text = arrayList[0]

        val gridAFragment = GridAFragment()
        val gridBFragment = GridBFragment()
        val gridCFragment = GridCFragment()
        val gridGFragment = GridGFragment()
        val commonFragment = CommonFragment()


        childFragmentManager.beginTransaction().apply {
            replace(R.id.fragment, commonFragment)
            commit()
        }

        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                setCurrentFragment(gridArrayList,position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(context, "Nothing Selected", Toast.LENGTH_SHORT).show()
            }
        }


        binding.common.setOnClickListener {
            childFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, commonFragment)
                commit()
                binding.titleTop.text = arrayList[0]
            }
        }

        binding.btnZoneA.setOnClickListener {
            childFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, gridAFragment)
                commit()
                binding.titleTop.text = arrayList[1]
            }
        }

        binding.btnZoneB.setOnClickListener {
            childFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, gridBFragment)
                commit()
                binding.titleTop.text = arrayList[2]
            }
        }

        binding.btnZoneC.setOnClickListener {
            childFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, gridCFragment)
                commit()
                binding.titleTop.text = arrayList[3]
            }
        }
        binding.btnZoneG.setOnClickListener {
            childFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, gridGFragment)
                commit()
                binding.titleTop.text = arrayList[7]
            }
        }
    }

    private fun setCurrentFragment(gridArrayList: ArrayList<Fragment>, position: Int) {

    }


}







