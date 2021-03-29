package com.hybrid.temiui.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentMapBinding
import com.robotemi.sdk.Robot
import com.robotemi.sdk.TtsRequest

class MapFragment : Fragment(R.layout.fragment_map) {

    private lateinit var binding: FragmentMapBinding
    val robot = Robot.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootview: View = inflater.inflate(R.layout.fragment_map,container,false)

        return rootview
    }


}



