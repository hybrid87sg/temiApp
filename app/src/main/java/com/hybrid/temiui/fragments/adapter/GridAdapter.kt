package com.hybrid.temiui.fragments.adapter


import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.hybrid.temiui.R
import com.hybrid.temiui.fragments.model.GridItem
import java.util.zip.Inflater

class GridAdapter(var context: Context,var arrayList: ArrayList<GridItem>) : BaseAdapter() {
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return arrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View = View.inflate(context, R.layout.cardview_item_grid,null)
        val icons:TextView = view.findViewById(R.id.gridButton)

        val lisItem:GridItem = arrayList[position]

        icons.text = lisItem.name



        return view
    }
}