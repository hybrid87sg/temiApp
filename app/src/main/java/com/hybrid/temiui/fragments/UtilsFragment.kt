package com.hybrid.temiui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentUtilsBinding
import com.hybrid.temiui.fragments.adapter.GridBrandsAdapter
import com.hybrid.temiui.fragments.adapter.GridUtilsAdapter
import com.hybrid.temiui.fragments.model.GridItemBrands
import com.hybrid.temiui.fragments.model.GridItemUtils
import com.robotemi.sdk.Robot

class UtilsFragment : Fragment(R.layout.fragment_utils), AdapterView.OnItemClickListener {

    private lateinit var binding: FragmentUtilsBinding

    private val robot = Robot.getInstance()

    private var arrayList:ArrayList<GridItemUtils>?=null
    private var gridAdapter : GridUtilsAdapter?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUtilsBinding.bind(view)

        arrayList = ArrayList()
        arrayList = setDataList()
        gridAdapter = context?.let{ GridUtilsAdapter(it,arrayList!!) }
        binding.gridUtils.adapter = gridAdapter
        binding.gridUtils.onItemClickListener = this
    }

    private fun setDataList():ArrayList<GridItemUtils>{
        val arrayList:ArrayList<GridItemUtils> = ArrayList()

        arrayList.add(GridItemUtils(R.drawable.showmewhere_utilities_coffeebar,"coffeebar"))
        arrayList.add(GridItemUtils(R.drawable.showmewhere_utilities_toilet,"toilet"))
        arrayList.add(GridItemUtils(R.drawable.showmewhere_utilities_infocounter,"homebase"))
        arrayList.add(GridItemUtils(R.drawable.showmewhere_utilities_decornmore,"decornmore"))

        return arrayList
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val booth:GridItemUtils = arrayList!![position]
        robot.goTo(booth.name.toString())
    }

}
