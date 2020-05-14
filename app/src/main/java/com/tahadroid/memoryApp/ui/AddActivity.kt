package com.tahadroid.memoryApp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.tahadroid.memoryApp.R
import com.tahadroid.memoryApp.adapter.TabAdapter
import com.tahadroid.memoryApp.pojo.Category
import com.tahadroid.memoryApp.pojo.MyTab
import com.tahadroid.memoryApp.repository.local.MemoryDatabase
import com.tahadroid.memoryApp.ui.fragment.MemoryDataFragment
import com.tahadroid.memoryApp.ui.fragment.MemoryMapFragment

class AddActivity : AppCompatActivity() {
    private val myDb = MemoryDatabase
    lateinit var tabLayout: TabLayout
    lateinit var  viewPager: ViewPager
    lateinit var tabAdapter: TabAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)


        tabLayout = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.view_pager)

        tabAdapter = TabAdapter(
            supportFragmentManager
        )

        val category1 = Category("Visited Places" )
        val category2 = Category("Show in Map")


        val mapFragment =
            MemoryMapFragment()
        val recyclerFragment =
            MemoryDataFragment()

        val myTab1 = MyTab(recyclerFragment, category1)
        val myTab2 = MyTab(mapFragment, category2)

        tabAdapter.addTab(myTab1)
        tabAdapter.addTab(myTab2)


        viewPager.adapter=tabAdapter

        tabLayout.setupWithViewPager(viewPager)

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.delete_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.delete_all -> {
            myDb.getInstance(this)?.memoryDao()?.deleteAll()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

}

