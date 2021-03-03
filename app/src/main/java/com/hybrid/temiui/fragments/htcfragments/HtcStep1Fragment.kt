package com.hybrid.temiui.fragments.htcfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentHtcStep1Binding


class HtcStep1Fragment : Fragment(R.layout.fragment_htc_step1) {

    private lateinit var binding:FragmentHtcStep1Binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHtcStep1Binding.bind(view)
    }

}