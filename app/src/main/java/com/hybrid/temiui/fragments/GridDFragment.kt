package com.hybrid.temiui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentGridCBinding
import com.hybrid.temiui.databinding.FragmentGridDBinding
import com.hybrid.temiui.fragments.adapter.GridAdapter
import com.hybrid.temiui.fragments.adapter.GridCAdapter
import com.hybrid.temiui.fragments.adapter.GridDAdapter
import com.hybrid.temiui.fragments.model.GridItemC
import com.hybrid.temiui.fragments.model.GridItemD
import com.robotemi.sdk.Robot


class GridDFragment : Fragment(R.layout.fragment_grid_d),AdapterView.OnItemClickListener{

    private lateinit var binding: FragmentGridDBinding

    private val robot = Robot.getInstance()

    private var arrayList: ArrayList<GridItemD>? = null
    private var gridAdapter: GridDAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGridDBinding.bind(view)

        arrayList = ArrayList()
        arrayList = setDataList()
        gridAdapter = context?.let { GridDAdapter(it, arrayList!!) }
        binding.gvZoneD.adapter = gridAdapter
        binding.gvZoneD.onItemClickListener = this
    }

    private fun setDataList(): ArrayList<GridItemD> {
        val arrayList: ArrayList<GridItemD> = ArrayList()

        arrayList.add(GridItemD(R.string.d1, "d1"))
        arrayList.add(GridItemD(R.string.d2, "d2"))
        arrayList.add(GridItemD(R.string.d3, "d3"))
        arrayList.add(GridItemD(R.string.d4, "d4"))
        arrayList.add(GridItemD(R.string.d5, "d5"))
        arrayList.add(GridItemD(R.string.d6, "d6"))
        arrayList.add(GridItemD(R.string.d7, "d7"))

        return arrayList

    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val booth: GridItemD = arrayList!![position]
        robot.goTo(booth.name.toString())
        Toast.makeText(context, "Going to " + booth.name, Toast.LENGTH_LONG).show()
    }

}