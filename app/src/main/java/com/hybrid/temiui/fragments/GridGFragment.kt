package com.hybrid.temiui.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentGridGBinding
import com.hybrid.temiui.fragments.adapter.GridGAdapter
import com.hybrid.temiui.fragments.model.GridItemG
import com.robotemi.sdk.Robot
import com.robotemi.sdk.TtsRequest


class GridGFragment : Fragment(R.layout.fragment_grid_g),AdapterView.OnItemClickListener {

    private lateinit var binding: FragmentGridGBinding
    private val robot = Robot.getInstance()

    private var arrayList : ArrayList<GridItemG>?=null
    private var gridAdapter:GridGAdapter?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGridGBinding.bind(view)

        arrayList = ArrayList()
        arrayList = setDataList()
        gridAdapter = context?.let { GridGAdapter(it,arrayList!!) }
        binding.gvZoneG.adapter = gridAdapter
        binding.gvZoneG.onItemClickListener = this

    }

    private fun setDataList():ArrayList<GridItemG>{
        val arrayList:ArrayList<GridItemG> = ArrayList()

        arrayList.add(GridItemG(R.string.g1,"g1"))
        arrayList.add(GridItemG(R.string.g2,"g2"))
        arrayList.add(GridItemG(R.string.g3,"g3"))

        return arrayList
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val booth:GridItemG = arrayList!![position]
        robot.goTo(booth.name.toString())
        robot.speak(TtsRequest.create("Follow me to "+booth.name,false))
        val dialog = TemiNavFragment()
        dialog.isCancelable = false
        dialog.show(childFragmentManager,"Temi Nav")
    }


}