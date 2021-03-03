package com.hybrid.temiui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentGridCBinding
import com.hybrid.temiui.databinding.FragmentGridFBinding
import com.hybrid.temiui.fragments.adapter.GridAdapter
import com.hybrid.temiui.fragments.adapter.GridCAdapter
import com.hybrid.temiui.fragments.adapter.GridFAdapter
import com.hybrid.temiui.fragments.model.GridItemC
import com.hybrid.temiui.fragments.model.GridItemF
import com.robotemi.sdk.Robot


class GridFFragment : Fragment(R.layout.fragment_grid_f),AdapterView.OnItemClickListener{

    private lateinit var binding: FragmentGridFBinding

    private val robot = Robot.getInstance()

    private var arrayList: ArrayList<GridItemF>? = null
    private var gridAdapter: GridFAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGridFBinding.bind(view)

        arrayList = ArrayList()
        arrayList = setDataList()
        gridAdapter = context?.let { GridFAdapter(it, arrayList!!) }
        binding.gvZoneF.adapter = gridAdapter
        binding.gvZoneF.onItemClickListener = this
    }

    private fun setDataList(): ArrayList<GridItemF> {
        val arrayList: ArrayList<GridItemF> = ArrayList()

        arrayList.add(GridItemF(R.string.f1, "f1"))
        arrayList.add(GridItemF(R.string.f2, "f2"))
        arrayList.add(GridItemF(R.string.f3, "f3"))
        arrayList.add(GridItemF(R.string.f4, "f4"))
        arrayList.add(GridItemF(R.string.f5, "f5"))

        return arrayList

    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val booth: GridItemF = arrayList!![position]
        robot.goTo(booth.name.toString())
        Toast.makeText(context, "Going to " + booth.name, Toast.LENGTH_LONG).show()
    }

}