package com.hybrid.temiui.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentUtilsBinding
import com.hybrid.temiui.fragments.adapter.GridUtilsAdapter
import com.hybrid.temiui.fragments.model.GridItemUtils
import com.robotemi.sdk.Robot
import com.robotemi.sdk.TtsRequest


class UtilsFragment : Fragment(R.layout.fragment_utils), AdapterView.OnItemClickListener {

    private lateinit var binding: FragmentUtilsBinding

    private val robot = Robot.getInstance()

    private var arrayList: ArrayList<GridItemUtils>? = null
    private var gridAdapter: GridUtilsAdapter? = null




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUtilsBinding.bind(view)

        arrayList = ArrayList()
        arrayList = setDataList()
        gridAdapter = context?.let { GridUtilsAdapter(it, arrayList!!) }
        binding.gridUtils.adapter = gridAdapter
        binding.gridUtils.onItemClickListener = this
    }

    private fun setDataList(): ArrayList<GridItemUtils> {
        val arrayList: ArrayList<GridItemUtils> = ArrayList()

        arrayList.add(GridItemUtils(R.drawable.utilities_menu_coffeebar, "coffee bar"))
        arrayList.add(GridItemUtils(R.drawable.utilities_menu_toilet, "toilet"))
        arrayList.add(GridItemUtils(R.drawable.utilities_menu_info, "home base"))
        arrayList.add(GridItemUtils(R.drawable.utilities_menu_decornmore, "decornmore"))

        return arrayList
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val booth: GridItemUtils = arrayList!![position]
        robot.goTo(booth.name.toString())
        robot.speak(TtsRequest.create("Follow me to " + booth.name, false))
        val dialog = TemiNavFragment()
        dialog.isCancelable = false
        dialog.show(childFragmentManager,"Temi Nav")
    }


}




