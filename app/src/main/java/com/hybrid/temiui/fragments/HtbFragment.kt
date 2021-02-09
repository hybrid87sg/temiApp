package com.hybrid.temiui.fragments


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentHtbBinding

class HtbFragment : Fragment(R.layout.fragment_htb) {
    
    private lateinit var binding: FragmentHtbBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHtbBinding.bind(view)


        binding.backTwo.setOnClickListener {
            binding.ivHtb.setImageResource(R.drawable.temiux_htp1)
            binding.control2.visibility = View.GONE
            binding.nextOne.visibility = View.VISIBLE
            binding.tvHtp.text = getText(R.string.step1)
        }
        binding.nextOne. setOnClickListener {
            binding.ivHtb.setImageResource(R.drawable.temiux_htp2)
            binding.control2.visibility = View.VISIBLE
            binding.nextOne.visibility = View.GONE
            binding.tvHtp.text = getText(R.string.step2)
        }
        binding.backOne. setOnClickListener {
            binding.ivHtb.setImageResource(R.drawable.temiux_htp2)
            binding.backOne.visibility = View.GONE
            binding.control2.visibility = View.VISIBLE
            binding.tvHtp.text = getText(R.string.step2)

        }
        binding.nextTwo . setOnClickListener {
            binding.ivHtb.setImageResource(R.drawable.temiux_htp3)
            binding.control2.visibility = View.GONE
            binding.backOne.visibility = View.VISIBLE
            binding.tvHtp.text = getText(R.string.step3)
        }
    }
}