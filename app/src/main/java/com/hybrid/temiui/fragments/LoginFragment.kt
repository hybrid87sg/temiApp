package com.hybrid.temiui.fragments

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.hybrid.temiui.MainActivity
import com.hybrid.temiui.R
import com.hybrid.temiui.SettingsActivity


class LoginFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootview: View = inflater.inflate(R.layout.fragment_login, container, false)

        val btnLogin = rootview.findViewById<Button>(R.id.btnLogin)
        val login = rootview.findViewById<EditText>(R.id.login)


        btnLogin.setOnClickListener {
            

            if (login.text.toString() == "4203") {
                val intent = Intent(context,SettingsActivity::class.java)
                startActivity(intent)
                dismiss()
            }
            else {
                Toast.makeText(context, "Login failed", Toast.LENGTH_SHORT).show()
                dismiss()
            }
        }


        return rootview
    }
}