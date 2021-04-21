package com.example.companyaplication.ui

import android.os.Bundle
import android.view.View
import com.example.companyaplication.R
import com.example.companyaplication.adapters.FragmentPagerAdapter
import com.example.companyaplication.base.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment: BaseFragment() {
    override val layoutId: Int= R.layout.main_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager2.adapter=FragmentPagerAdapter(childFragmentManager,lifecycle)
        TabLayoutMediator(tabLayout,viewPager2){tab,position->
            when(position){
                0->tab.text="My Team"
                1->tab.text="All Teams"
                2->tab.text="My Company"
            }
        }.attach()
    }
}