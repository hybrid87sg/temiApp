package com.hybrid.temiui.fragments

import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.View
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentMainBinding
import com.hybrid.temiui.databinding.FragmentMapBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        val htcFragment = HtcFragment()
        val htbFragment = HtbFragment()

        binding.htcBtn.setOnClickListener {
            setCurrentFragment(htcFragment)
        }
        binding.htbBtn.setOnClickListener {
            setCurrentFragment(htbFragment)
        }

    }

    private fun setCurrentFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction().apply {
            replace(R.id.htFrame,fragment)
            commit()
        }
    }

}

