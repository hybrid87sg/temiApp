package com.hybrid.temiui.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hybrid.temiui.R


class HtbPagerAdapter(childFragmentManager: FragmentManager) : FragmentPagerAdapter(
    childFragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    private val mImagesList = ArrayList<Fragment>()
    private val mImagesTitle = ArrayList<String>()

    override fun getCount(): Int {
        return mImagesList.size
    }

    override fun getItem(position: Int): Fragment {
        return mImagesList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mImagesTitle[position]
    }


    fun addFragment(fragment: Fragment, title: String) {
        mImagesList.add(fragment)
        mImagesTitle.add(title)

    }
}