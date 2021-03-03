package com.hybrid.temiui.fragments.htcfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentHtcStep1Binding
import com.hybrid.temiui.databinding.FragmentHtcStep2Binding


class HtcStep2Fragment : Fragment(R.layout.fragment_htc_step2) {

    private lateinit var binding:FragmentHtcStep2Binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHtcStep2Binding.bind(view)
    }

}