package com.hybrid.temiui.fragments


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.DialogFragment
import com.hybrid.temiui.MapActivity
import com.hybrid.temiui.R

class ViewZoneFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val rootView: View = inflater.inflate(R.layout.fragment_view_zone, container, false)

        val zoneView = rootView.findViewById<Button>(R.id.btnZoneView)
        val zoneIv = rootView.findViewById<ImageButton>(R.id.ibZonebtn)
        val mapView = rootView.findViewById<Button>(R.id.btnMapView)

        val mapFragment = MapFragment()

        zoneIv.setOnClickListener {
            val intentZone = Intent(context, MapActivity::class.java)
            startActivity(intentZone)
        }

        zoneView.setOnClickListener {
            val intentZone = Intent(context, MapActivity::class.java)
            startActivity(intentZone)
        }

        mapView.setOnClickListener {
            val intentZone = Intent(context, MapActivity::class.java)
            startActivity(intentZone)
        }

        return rootView
    }

}