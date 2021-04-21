package com.example.companyaplication.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.companyaplication.ui.AllTeamFragment
import com.example.companyaplication.ui.MyCompanyFragment
import com.example.companyaplication.ui.MyTeamFragment

class FragmentPagerAdapter(private val fragmentManager: FragmentManager,lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager,lifecycle) {
    private val allTeamFragment: AllTeamFragment = AllTeamFragment()
    private val myTeamFragment:MyTeamFragment = MyTeamFragment()
    private val myCompanyFragment: MyCompanyFragment = MyCompanyFragment()

    companion object{
        const val PAGE_SIZE=3
    }


    override fun getItemCount(): Int {
        return PAGE_SIZE
    }

    override fun createFragment(position: Int): Fragment {
       return when(position){
            1->allTeamFragment
            2->myCompanyFragment
           else -> myTeamFragment
       }
    }

}