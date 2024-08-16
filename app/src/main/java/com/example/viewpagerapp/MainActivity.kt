package com.example.viewpagerapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager2:ViewPager2
    private lateinit var myAdapter:MyPagerAdapter
    private lateinit var tabLayout: TabLayout

    var tabsArray = arrayOf("My App","Coding","Last Advice","Pro Tips")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager2 = findViewById(R.id.viewPage2)
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        myAdapter = MyPagerAdapter(supportFragmentManager,lifecycle)
        myAdapter.addFragmentToList(FragmentOne())
        myAdapter.addFragmentToList(FragmentTwo())
        myAdapter.addFragmentToList(FragmentThree())
        myAdapter.addFragmentToList(FragmentFour())

        viewPager2.adapter = myAdapter

       tabLayout=findViewById(R.id.tabLayout)
        TabLayoutMediator(tabLayout,viewPager2){
            tab,position ->
        //    tab.text = "Tab ${position +1}"
            tab.text = tabsArray[position]
        }.attach()

    }
}