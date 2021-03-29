package com.hybrid.temiui.fragments

import android.app.AlertDialog
import android.app.SharedElementCallback
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentGridABinding
import com.hybrid.temiui.fragments.adapter.GridAdapter
import com.hybrid.temiui.fragments.model.GridItemA
import com.robotemi.sdk.Robot
import com.robotemi.sdk.TtsRequest


class GridAFragment : Fragment(R.layout.fragment_grid_a), AdapterView.OnItemClickListener {

    private lateinit var binding: FragmentGridABinding

    private val robot = Robot.getInstance()

    private val temiNavFragment:ViewModel by activityViewModels()

    private var arrayList: ArrayList<GridItemA>? = null
    private var gridAdapter: GridAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGridABinding.bind(view)

        arrayList = ArrayList()
        arrayList = setDataList()
        gridAdapter = context?.let { GridAdapter(it, arrayList!!) }
        binding.gvZoneA.adapter = gridAdapter
        binding.gvZoneA.onItemClickListener = this
    }

    private fun setDataList(): ArrayList<GridItemA> {
        val arrayList: ArrayList<GridItemA> = ArrayList()

        arrayList.add(GridItemA(R.string.a1, "a1"))
        arrayList.add(GridItemA(R.string.a2, "a2"))
        arrayList.add(GridItemA(R.string.a3, "a3"))
        arrayList.add(GridItemA(R.string.a4, "a4"))
        arrayList.add(GridItemA(R.string.a5, "a5"))
        arrayList.add(GridItemA(R.string.a6, "a6"))
        arrayList.add(GridItemA(R.string.a7, "a7"))
        arrayList.add(GridItemA(R.string.a8, "a8"))
        arrayList.add(GridItemA(R.string.a9, "a9"))

        return arrayList

    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val booth: GridItemA = arrayList!![position]
        robot.goTo(booth.name.toString())
        robot.speak(TtsRequest.create("Follow me to "+booth.name,false))
        val dialog = TemiNavFragment()
        dialog.isCancelable = false
        dialog.show(childFragmentManager,"Temi Nav")

    }
}
