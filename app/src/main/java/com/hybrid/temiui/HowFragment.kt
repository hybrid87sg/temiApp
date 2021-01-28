package com.hybrid.temiui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.hybrid.temiui.databinding.FragmentHowBinding


class HowFragment : Fragment(R.layout.fragment_how) {

     private lateinit var binding: FragmentHowBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHowBinding.bind(view)



    }
}