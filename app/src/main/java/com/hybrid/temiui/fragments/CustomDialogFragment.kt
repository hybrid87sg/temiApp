package com.hybrid.temiui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.hybrid.temiui.R


class CustomDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootview: View = inflater.inflate(R.layout.fragment_custom_dialog,container,false)
        val btnClose: Button = rootview.findViewById(R.id.btnClose)

            btnClose.setOnClickListener {
                dismiss()
            }

        return rootview
    }
}