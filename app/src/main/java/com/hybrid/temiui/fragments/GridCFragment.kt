package com.hybrid.temiui.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentGridCBinding
import com.hybrid.temiui.fragments.adapter.GridAdapter
import com.hybrid.temiui.fragments.adapter.GridCAdapter
import com.hybrid.temiui.fragments.model.GridItemC
import com.robotemi.sdk.Robot
import com.robotemi.sdk.TtsRequest


class GridCFragment : Fragment(R.layout.fragment_grid_c),AdapterView.OnItemClickListener{

    private lateinit var binding: FragmentGridCBinding

    private val robot = Robot.getInstance()

    private var arrayList: ArrayList<GridItemC>? = null
    private var gridAdapter: GridCAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGridCBinding.bind(view)

        arrayList = ArrayList()
        arrayList = setDataList()
        gridAdapter = context?.let { GridCAdapter(it, arrayList!!) }
        binding.gvZoneC.adapter = gridAdapter
        binding.gvZoneC.onItemClickListener = this
    }

    private fun setDataList(): ArrayList<GridItemC> {
        val arrayList: ArrayList<GridItemC> = ArrayList()

        arrayList.add(GridItemC(R.string.c1, "c1"))
        arrayList.add(GridItemC(R.string.c2, "c2"))
        arrayList.add(GridItemC(R.string.c3, "c3"))
        arrayList.add(GridItemC(R.string.c4, "c4"))
        arrayList.add(GridItemC(R.string.c5, "c5"))
        arrayList.add(GridItemC(R.string.c6, "c6"))

        return arrayList

    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val booth: GridItemC = arrayList!![position]
        robot.goTo(booth.name.toString())
        robot.speak(TtsRequest.create("Follow me to "+booth.name,false))
        val dialog = TemiNavFragment()
        dialog.isCancelable = false
        dialog.show(childFragmentManager,"Temi Nav")
    }

}