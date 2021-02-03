package com.hybrid.temiui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.hybrid.temiui.R
import com.hybrid.temiui.databinding.FragmentZoneBinding
import com.hybrid.temiui.fragments.adapter.GridAdapter
import com.hybrid.temiui.fragments.adapter.GridZoneAdapter
import com.hybrid.temiui.fragments.model.GridItem
import com.hybrid.temiui.fragments.model.GridItemB
import com.hybrid.temiui.fragments.model.GridZone
import com.robotemi.sdk.Robot
import com.robotemi.sdk.TtsRequest


class ZoneFragment : Fragment(R.layout.fragment_zone), AdapterView.OnItemClickListener {

    private lateinit var binding: FragmentZoneBinding
    private val robot = Robot.getInstance()
    private var arrayListA: ArrayList<GridItem>? = null
    private var arrayListB: ArrayList<GridItemB>? = null
    private var arrayListZone: ArrayList<GridZone>? = null
    private var gridAdapter: GridAdapter? = null
    private var gridZoneAdapter: GridZoneAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentZoneBinding.bind(view)


        arrayListA = ArrayList()
        arrayListA = setDataListA()
        arrayListB = ArrayList()
        arrayListB = setDataListB()

        arrayListZone = ArrayList()
        arrayListZone = setDataListZone()

        gridAdapter = context?.let { GridAdapter(it, arrayListA!!) }
        gridZoneAdapter = context?.let { GridZoneAdapter(it,arrayListZone!!) }
        binding.gridViewLayout.adapter = gridAdapter
        binding.gridViewLayout.onItemClickListener = this
        binding.zoneGrid.adapter = gridZoneAdapter
        binding.zoneGrid.onItemClickListener = this


        binding.ivZoneA.setOnClickListener {
            binding.gridZoneB.visibility = View.GONE
            binding.gridZoneA.visibility = View.VISIBLE
        }

        binding.ivZoneB.setOnClickListener {
            binding.gridZoneB.visibility = View.VISIBLE
            binding.gridZoneA.visibility = View.GONE
        }
        binding.ivZoneB.setOnClickListener {
            binding.gridZoneB.visibility = View.VISIBLE
            binding.gridZoneA.visibility = View.GONE
        }
        binding.ivZoneC.setOnClickListener {
            binding.gridZoneB.visibility = View.VISIBLE
            binding.gridZoneA.visibility = View.GONE
        }
        binding.ivZoneB.setOnClickListener {
            binding.gridZoneB.visibility = View.VISIBLE
            binding.gridZoneA.visibility = View.GONE
        }
        binding.ivZoneB.setOnClickListener {
            binding.gridZoneB.visibility = View.VISIBLE
            binding.gridZoneA.visibility = View.GONE
        }
        binding.ivZoneB.setOnClickListener {
            binding.gridZoneB.visibility = View.VISIBLE
            binding.gridZoneA.visibility = View.GONE
        }

        binding.a1.setOnClickListener {
            //robot.goTo("a1")
            robot.speak(TtsRequest.create("Follow me to A1", false))
            Snackbar.make(view, "Follow me to A1", 2000).show()

        }

        /*binding.zoneGrid.setOnItemClickListener(new OnItemClickListener){

        }*/


    }

    private fun setDataListA(): ArrayList<GridItem> {
        val arrayList: ArrayList<GridItem> = ArrayList()

        arrayList.add(GridItem(R.string.a1, "A1"))
        arrayList.add(GridItem(R.string.a2, "A2"))
        arrayList.add(GridItem(R.string.a3, "A3"))
        arrayList.add(GridItem(R.string.a4, "A4"))
        arrayList.add(GridItem(R.string.a5, "A5"))
        arrayList.add(GridItem(R.string.a6, "A6"))
        arrayList.add(GridItem(R.string.a7, "A7"))
        arrayList.add(GridItem(R.string.a8, "A8"))
        arrayList.add(GridItem(R.string.a9, "A9"))

        return arrayList
    }

    private fun setDataListB(): ArrayList<GridItemB> {
        val arrayListB: ArrayList<GridItemB> = ArrayList()

        arrayListB.add(GridItemB(R.string.b1, "B1"))
        arrayListB.add(GridItemB(R.string.b2, "B2"))
        arrayListB.add(GridItemB(R.string.b3, "B3"))
        arrayListB.add(GridItemB(R.string.b4, "B4"))
        arrayListB.add(GridItemB(R.string.b5, "B5"))
        arrayListB.add(GridItemB(R.string.b6, "B6"))
        arrayListB.add(GridItemB(R.string.b7, "B7"))

        return arrayListB
    }

    private fun setDataListZone(): ArrayList<GridZone> {
        val arrayListZone: ArrayList<GridZone> = ArrayList()

        arrayListZone.add(GridZone(R.drawable.showmewhere_zonea, "Zone A"))
        arrayListZone.add(GridZone(R.drawable.showmewhere_zoneb, "Zone B"))
        arrayListZone.add(GridZone(R.drawable.showmewhere_zonec, "Zone C"))
        arrayListZone.add(GridZone(R.drawable.showmewhere_zoned, "Zone D"))
        arrayListZone.add(GridZone(R.drawable.showmewhere_zonee, "Zone E"))
        arrayListZone.add(GridZone(R.drawable.showmewhere_zonef, "Zone F"))
        arrayListZone.add(GridZone(R.drawable.showmewhere_zoneg, "Zone G"))

        return arrayListZone
    }


    /*override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val itemsA: GridItem = arrayListA!![position]
        //val itemsB: GridItemB = arrayListB!![position]


        robot.goTo(itemsA.name.toString())
        Toast.makeText(context, itemsA.name, Toast.LENGTH_SHORT).show()

        robot.goTo(itemsB.name.toString())
        Toast.makeText(context, itemsB.name, Toast.LENGTH_SHORT).show()


    }*/

    override fun onItemClick(parent: AdapterView<*>?,view: View,position: Int,id: Long){

        val itemsZone: GridZone = arrayListZone!![position]

        Toast.makeText(context,itemsZone.name,Toast.LENGTH_SHORT).show()
        binding.titleTop.text = itemsZone.name
    }


}
