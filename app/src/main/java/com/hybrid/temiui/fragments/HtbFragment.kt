package com.hybrid.temiui.fragments


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import coil.load
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentHtbBinding
import com.hybrid.temiui.fragments.adapter.HtbPagerAdapter
import com.hybrid.temiui.fragments.htbfragments.HtbStep1Fragment
import com.hybrid.temiui.fragments.htbfragments.HtbStep2Fragment
import com.hybrid.temiui.fragments.htbfragments.HtbStep3Fragment

class HtbFragment : Fragment(R.layout.fragment_htb) {
    
    private lateinit var binding: FragmentHtbBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHtbBinding.bind(view)

        //setupTabs()

        binding.stepBarHtb1.setOnClickListener {
            binding.ivHtb.load(R.drawable.temiux_htp1)
        }
        binding.stepBarHtb2.setOnClickListener {
            binding.ivHtb.load(R.drawable.temiux_htp2)
        }
        binding.stepBarHtb3.setOnClickListener {
            binding.ivHtb.load(R.drawable.temiux_htp3)
        }

    }

    /*private fun setupTabs(){
        val adapter = HtbPagerAdapter(childFragmentManager)
        adapter.addFragment(HtbStep1Fragment(),"Step 1")
        adapter.addFragment(HtbStep2Fragment(),"Step 2")
        adapter.addFragment(HtbStep3Fragment(),"Step 3")

        binding.vpHtb.adapter = adapter
        binding.tabBarHtb.setupWithViewPager(binding.vpHtb)

        binding.tabBarHtb.getTabAt(0)?.text = getString(R.string.step1)
        binding.tabBarHtb.getTabAt(1)?.text = getString(R.string.step2)
        binding.tabBarHtb.getTabAt(2)?.text = getString(R.string.step3)
    }*/
}