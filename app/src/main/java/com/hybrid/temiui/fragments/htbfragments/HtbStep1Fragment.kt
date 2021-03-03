package com.hybrid.temiui.fragments.htbfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentHtbStep1Binding


class HtbStep1Fragment : Fragment(R.layout.fragment_htb_step1) {
    private lateinit var binding:FragmentHtbStep1Binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHtbStep1Binding.bind(view)
    }
}