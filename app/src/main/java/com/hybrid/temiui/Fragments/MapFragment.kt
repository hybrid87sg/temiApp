package com.hybrid.temiui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import coil.load
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentMapBinding

class MapFragment : Fragment(R.layout.fragment_map) {

    private lateinit var binding: FragmentMapBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMapBinding.bind(view)

        binding.ivMap.load(R.drawable.temiux_mappage)

    }
}
