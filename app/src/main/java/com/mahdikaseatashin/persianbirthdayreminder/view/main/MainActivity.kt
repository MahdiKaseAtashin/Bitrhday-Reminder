package com.mahdikaseatashin.persianbirthdayreminder.view.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.mahdikaseatashin.persianbirthdayreminder.R
import com.mahdikaseatashin.persianbirthdayreminder.view.add.AddActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var frameLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialization()
    }

    private fun initialization() {
        tabLayout = findViewById(R.id.tl_main)
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_home))
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_up_coming))
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_favorite))
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_search))

        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        frameLayout = findViewById(R.id.fl_main)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> {
                        val all = All()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fl_main, all)
                            .commitAllowingStateLoss()
                    }
                    1 -> {
                        val upComing = UpComing()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fl_main, upComing)
                            .commitAllowingStateLoss()

                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    fun addUser(view: View) {
        when (view.id){
            fab_main.id -> {
                val i2 = Intent(this, AddActivity::class.java)
                startActivity(i2)
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up)
            }
        }
    }
}
