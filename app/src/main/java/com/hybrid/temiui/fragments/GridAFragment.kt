package com.hybrid.temiui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentGridABinding
import com.hybrid.temiui.fragments.adapter.GridAdapter
import com.hybrid.temiui.fragments.model.GridItemA
import com.robotemi.sdk.Robot


class GridAFragment : Fragment(R.layout.fragment_grid_a), AdapterView.OnItemClickListener {

    private lateinit var binding: FragmentGridABinding

    private val robot = Robot.getInstance()

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

        arrayList.add(GridItemA(R.string.a1, "A1"))
        arrayList.add(GridItemA(R.string.a2, "A2"))
        arrayList.add(GridItemA(R.string.a3, "A3"))
        arrayList.add(GridItemA(R.string.a4, "A4"))
        arrayList.add(GridItemA(R.string.a5, "A5"))
        arrayList.add(GridItemA(R.string.a6, "A6"))
        arrayList.add(GridItemA(R.string.a7, "A7"))
        arrayList.add(GridItemA(R.string.a8, "A8"))
        arrayList.add(GridItemA(R.string.a9, "A9"))

        return arrayList

    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val booth: GridItemA = arrayList!![position]
        robot.goTo(booth.name.toString())
        Toast.makeText(context, "Going to " + booth.name, Toast.LENGTH_LONG).show()
    }
}
