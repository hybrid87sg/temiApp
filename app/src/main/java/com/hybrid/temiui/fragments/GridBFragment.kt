package com.hybrid.temiui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentGridBBinding
import com.hybrid.temiui.fragments.adapter.GridBAdapter
import com.hybrid.temiui.fragments.model.GridItemB
import com.robotemi.sdk.Robot


class GridBFragment : Fragment(R.layout.fragment_grid_b),AdapterView.OnItemClickListener{

    private lateinit var binding: FragmentGridBBinding

    private val robot = Robot.getInstance()

    private var arrayList: ArrayList<GridItemB>? = null
    private var gridAdapter: GridBAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGridBBinding.bind(view)

        arrayList = ArrayList()
        arrayList = setDataList()
        gridAdapter = context?.let { GridBAdapter(it, arrayList!!) }
        binding.gvZoneB.adapter = gridAdapter
        binding.gvZoneB.onItemClickListener = this
    }

    private fun setDataList(): ArrayList<GridItemB> {
        val arrayList: ArrayList<GridItemB> = ArrayList()

        arrayList.add(GridItemB(R.string.b1, "b1"))
        arrayList.add(GridItemB(R.string.b2, "b2"))
        arrayList.add(GridItemB(R.string.b3, "b3"))
        arrayList.add(GridItemB(R.string.b4, "b4"))
        arrayList.add(GridItemB(R.string.b5, "b5"))
        arrayList.add(GridItemB(R.string.b6, "b6"))
        arrayList.add(GridItemB(R.string.b7, "b7"))

        return arrayList

    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val booth: GridItemB = arrayList!![position]
        robot.goTo(booth.name.toString())
        Toast.makeText(context, "Going to " + booth.name, Toast.LENGTH_LONG).show()
    }

}