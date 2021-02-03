package com.hybrid.temiui.fragments.adapter

import android.annotation.SuppressLint
import android.widget.ImageView
import com.hybrid.temiui.fragments.model.GridZone
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.hybrid.temiui.R

class GridZoneAdapter(var context: Context,var arrayList: ArrayList<GridZone>) : BaseAdapter() {
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return arrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View = View.inflate(context, R.layout.zone_grid,null)
        val icons:ImageView = view.findViewById(R.id.ivZoneView)

        val lisItem:GridZone = arrayList[position]

        icons.setImageResource(lisItem.icons!!)



        return view
    }
}