package com.hybrid.temiui.fragments

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


class GridFFragment : Fragment(R.layout.fragment_grid_f),AdapterView.OnItemClickListener{

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

        arrayList.add(GridItemC(R.string.c1, "C1"))
        arrayList.add(GridItemC(R.string.c2, "C2"))
        arrayList.add(GridItemC(R.string.c3, "C3"))
        arrayList.add(GridItemC(R.string.c4, "C4"))
        arrayList.add(GridItemC(R.string.c5, "C5"))
        arrayList.add(GridItemC(R.string.c6, "C6"))

        return arrayList

    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val booth: GridItemC = arrayList!![position]
        robot.goTo(booth.name.toString())
        Toast.makeText(context, "Going to " + booth.name, Toast.LENGTH_LONG).show()
    }

}