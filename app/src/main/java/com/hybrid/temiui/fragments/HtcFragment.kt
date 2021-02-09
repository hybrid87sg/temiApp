package com.hybrid.temiui.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.hybrid.temiui.MainActivity
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentHtcBinding

class HtcFragment : Fragment(R.layout.fragment_htc) {

    private lateinit var binding: FragmentHtcBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHtcBinding.bind(view)

        binding.backTwo.setOnClickListener {
            binding.ivHtc.setImageResource(R.drawable.temiux_htc1)
            binding.control2.visibility = View.GONE
            binding.nextOne.visibility = View.VISIBLE
            binding.tvHtc.text = getText(R.string.step1)
        }
        binding.nextOne. setOnClickListener {
            binding.ivHtc.setImageResource(R.drawable.temiux_htc2)
            binding.control2.visibility = View.VISIBLE
            binding.nextOne.visibility = View.GONE
            binding.tvHtc.text = getText(R.string.step2)
        }
        binding.backOne. setOnClickListener {
            binding.ivHtc.setImageResource(R.drawable.temiux_htc2)
            binding.backOne.visibility = View.GONE
            binding.control2.visibility = View.VISIBLE
            binding.tvHtc.text = getText(R.string.step2)

        }
        binding.nextTwo . setOnClickListener {
            binding.ivHtc.setImageResource(R.drawable.temiux_htc3)
            binding.control2.visibility = View.GONE
            binding.backOne.visibility = View.VISIBLE
            binding.tvHtc.text = getText(R.string.step3)
        }

    }

}