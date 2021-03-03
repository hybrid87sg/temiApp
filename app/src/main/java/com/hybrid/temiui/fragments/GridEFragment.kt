package com.hybrid.temiui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentGridCBinding
import com.hybrid.temiui.databinding.FragmentGridEBinding
import com.hybrid.temiui.fragments.adapter.GridAdapter
import com.hybrid.temiui.fragments.adapter.GridCAdapter
import com.hybrid.temiui.fragments.adapter.GridEAdapter
import com.hybrid.temiui.fragments.model.GridItemC
import com.hybrid.temiui.fragments.model.GridItemE
import com.robotemi.sdk.Robot


class GridEFragment : Fragment(R.layout.fragment_grid_e),AdapterView.OnItemClickListener{

    private lateinit var binding: FragmentGridEBinding

    private val robot = Robot.getInstance()

    private var arrayList: ArrayList<GridItemE>? = null
    private var gridAdapter: GridEAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGridEBinding.bind(view)

        arrayList = ArrayList()
        arrayList = setDataList()
        gridAdapter = context?.let { GridEAdapter(it, arrayList!!) }
        binding.gvZoneE.adapter = gridAdapter
        binding.gvZoneE.onItemClickListener = this
    }

    private fun setDataList(): ArrayList<GridItemE> {
        val arrayList: ArrayList<GridItemE> = ArrayList()

        arrayList.add(GridItemE(R.string.e1, "e1"))
        arrayList.add(GridItemE(R.string.e2, "e2"))
        arrayList.add(GridItemE(R.string.e3, "e3"))
        arrayList.add(GridItemE(R.string.e4, "e4"))
        arrayList.add(GridItemE(R.string.e5, "e5"))
        arrayList.add(GridItemE(R.string.e6, "e6"))
        arrayList.add(GridItemE(R.string.e7, "e7"))
        arrayList.add(GridItemE(R.string.e8, "e8"))
        arrayList.add(GridItemE(R.string.e9, "e9"))
        arrayList.add(GridItemE(R.string.e10, "e10"))
        arrayList.add(GridItemE(R.string.e11, "e11"))

        return arrayList

    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val booth: GridItemE = arrayList!![position]
        robot.goTo(booth.name.toString())
        Toast.makeText(context, "Going to " + booth.name, Toast.LENGTH_LONG).show()
    }

}