package com.hybrid.temiui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentFaqBinding


class FaqFragment : Fragment(R.layout.fragment_faq) {

    private lateinit var binding:FragmentFaqBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFaqBinding.bind(view)

    }

}