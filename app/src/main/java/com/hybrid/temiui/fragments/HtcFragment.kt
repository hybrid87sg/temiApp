package com.hybrid.temiui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import coil.load
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentHtcBinding
import com.hybrid.temiui.fragments.adapter.HtcPagerAdapter
import com.hybrid.temiui.fragments.htcfragments.HtcStep1Fragment
import com.hybrid.temiui.fragments.htcfragments.HtcStep2Fragment
import com.hybrid.temiui.fragments.htcfragments.HtcStep3Fragment

class HtcFragment : Fragment(R.layout.fragment_htc) {

    private lateinit var binding: FragmentHtcBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHtcBinding.bind(view)

        binding.tvHtc.text = getString(R.string.htcdetail)

        //setupTabs()

        binding.stepBar1.setOnClickListener {
            binding.ivHtc.load(R.drawable.temiux_htc1)
        }
        binding.stepBar2.setOnClickListener {
            binding.ivHtc.load(R.drawable.temiux_htc2)
        }
        binding.stepBar3.setOnClickListener {
            binding.ivHtc.load(R.drawable.temiux_htc3)
        }

    }

    /*private fun setupTabs(){
        val adapter = HtcPagerAdapter(childFragmentManager)
        adapter.addFragment(HtcStep1Fragment(),"Step1")
        adapter.addFragment(HtcStep2Fragment(),"Step2")
        adapter.addFragment(HtcStep3Fragment(),"Step3")

        binding.vpHtc.adapter = adapter
        binding.tabBar.setupWithViewPager(binding.vpHtc)

        binding.tabBar.getTabAt(0)?.text = getString(R.string.step1)
        binding.tabBar.getTabAt(1)?.text = getString(R.string.step2)
        binding.tabBar.getTabAt(2)?.text = getString(R.string.step3)
    }*/

}