package com.tahadroid.memoryApp.ui.fragment

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.tahadroid.memoryApp.R
import com.tahadroid.memoryApp.adapter.MemoryDataAdapter
import com.tahadroid.memoryApp.repository.local.Memory
import com.tahadroid.memoryApp.repository.local.MemoryDatabase
import kotlinx.android.synthetic.main.fragment_memory_data.*


class MemoryDataFragment : BaseFragment(), (Memory) -> Unit {

lateinit var  memoryDataAdapter: MemoryDataAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_memory_data, container, false)
    }


    override fun onResume() {
        super.onResume()
        memory_data_rv.layoutManager= LinearLayoutManager(context)
        val sss=MemoryDatabase.getInstance(context as Activity)?.memoryDao()?.getAllMemories()
        sss.let {
            memoryDataAdapter= MemoryDataAdapter(it as MutableList<Memory>,this)
            memoryDataAdapter.removeAt()
        }
        memory_data_rv.adapter=memoryDataAdapter
    }

    override fun invoke(memory: Memory) {
        Toast.makeText(context,"Title :"+memory.mTitle
            +"\nDescription :"+memory.mDescription
            +"\nLat:"+memory.mLatitude+" _ Lng:"+memory.mLongitude, Toast.LENGTH_SHORT).show();
    }


}
