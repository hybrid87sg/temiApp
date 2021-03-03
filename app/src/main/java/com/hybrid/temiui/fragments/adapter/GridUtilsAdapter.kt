package com.hybrid.temiui.fragments.adapter


import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.hybrid.temiui.R
import com.hybrid.temiui.fragments.model.GridItemBrands
import com.hybrid.temiui.fragments.model.GridItemG
import com.hybrid.temiui.fragments.model.GridItemUtils

class GridUtilsAdapter(var context: Context, var arrayList: ArrayList<GridItemUtils>) : BaseAdapter() {
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
        val view:View = View.inflate(context, R.layout.utils_grid_item,null)
        val icons:ImageView = view.findViewById(R.id.icons)

        val listItem:GridItemUtils = arrayList[position]

        icons.setImageResource(listItem.icons!!)


        return view
    }
}