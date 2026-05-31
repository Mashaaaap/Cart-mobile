package com.example.shop.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.shop.fragment.CatalogFragment
import com.example.shop.fragment.CartFragment
import com.example.shop.fragment.FavoritesFragment
import com.example.shop.fragment.ProfileFragment

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount() = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CatalogFragment()
            1 -> CartFragment()
            2 -> FavoritesFragment()
            3 -> ProfileFragment()
            else -> CatalogFragment()
        }
    }
}