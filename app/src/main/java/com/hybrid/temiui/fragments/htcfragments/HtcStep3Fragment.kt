package com.hybrid.temiui.fragments.htcfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentHtcStep1Binding
import com.hybrid.temiui.databinding.FragmentHtcStep3Binding


class HtcStep3Fragment : Fragment(R.layout.fragment_htc_step3) {

    private lateinit var binding: FragmentHtcStep3Binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHtcStep3Binding.bind(view)
    }

}