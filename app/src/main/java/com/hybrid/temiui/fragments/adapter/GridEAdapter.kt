package com.hybrid.temiui.fragments.adapter


import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.hybrid.temiui.R
import com.hybrid.temiui.fragments.model.GridItemB
import com.hybrid.temiui.fragments.model.GridItemC
import com.hybrid.temiui.fragments.model.GridItemE

class GridEAdapter(var context: Context, var arrayList: ArrayList<GridItemE>) : BaseAdapter() {
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
        val view:View = View.inflate(context, R.layout.cardview_item_grid,null)
        val icons:TextView = view.findViewById(R.id.gridButton)

        val listItem: GridItemE = arrayList[position]

        icons.text = listItem.name



        return view
    }
}