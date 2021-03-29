package com.hybrid.temiui.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentBrandsBinding
import com.hybrid.temiui.fragments.adapter.GridBrandsAdapter
import com.hybrid.temiui.fragments.model.GridItemBrands
import com.robotemi.sdk.Robot
import com.robotemi.sdk.TtsRequest

class BrandsFragment : Fragment(R.layout.fragment_brands) , AdapterView.OnItemClickListener{

    private lateinit var binding: FragmentBrandsBinding

    private val robot = Robot.getInstance()

    private var arrayList:ArrayList<GridItemBrands>?=null
    private var gridAdapter :GridBrandsAdapter?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBrandsBinding.bind(view)

        arrayList = ArrayList()
        arrayList = setDataList()
        gridAdapter = context?.let{GridBrandsAdapter(it,arrayList!!)}
        binding.gridBrands.adapter = gridAdapter
        binding.gridBrands.onItemClickListener = this
    }

    private fun setDataList():ArrayList<GridItemBrands>{
        val arrayList:ArrayList<GridItemBrands> = ArrayList()

        arrayList.add(GridItemBrands(R.drawable.showmewhere_brands_haylee,"haylee"))
        arrayList.add(GridItemBrands(R.drawable.showmewhere_brands_kanex,"kanex"))
        arrayList.add(GridItemBrands(R.drawable.showmewhere_brands_newarrivals,"newarrivals"))
        arrayList.add(GridItemBrands(R.drawable.showmewhere_brands_fynelinen,"fynelinen"))
        arrayList.add(GridItemBrands(R.drawable.showmewhere_brands_beddingday,"beddingday"))
        arrayList.add(GridItemBrands(R.drawable.showmewhere_brands_outdoor,"outdoor"))
        arrayList.add(GridItemBrands(R.drawable.showmewhere_brands_softfurnishing,"softfurnishing"))
        arrayList.add(GridItemBrands(R.drawable.showmewhere_brands_mattresszone,"mattresszone"))
        arrayList.add(GridItemBrands(R.drawable.showmewhere_brands_rugsncarpets,"rugs and carpets"))

        return arrayList
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val booth:GridItemBrands = arrayList!![position]
        robot.goTo(booth.name.toString())
        robot.speak(TtsRequest.create("Follow me to "+booth.name,false))
        val dialog = TemiNavFragment()
        dialog.isCancelable = false
        dialog.show(childFragmentManager,"Temi Nav")
    }
}
