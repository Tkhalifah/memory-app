package com.tahadroid.memoryApp.ui.fragment

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.tahadroid.memoryApp.R
import com.tahadroid.memoryApp.repository.local.MemoryDatabase


@Suppress("DEPRECATED_IDENTITY_EQUALS")
class MemoryMapFragment : BaseFragment(), OnMapReadyCallback {
    private val myDb = MemoryDatabase
    private lateinit var mMap: GoogleMap
    lateinit var mapFragment: SupportMapFragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_memory_map, container, false)
        mapFragment = (childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?)!!
        mapFragment.getMapAsync(this)

        return rootView
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap!!

        val sss=MemoryDatabase.getInstance(context as Activity)?.memoryDao()?.getAllMemories()
        if (sss != null) {
            for(i in sss) {
                val latitude = i.mLatitude
                val longtude = i.mLongitude
                val title =i.mTitle
                val des =i.mDescription
                val myLocation = LatLng(latitude, longtude)
                mMap.addMarker(
                    MarkerOptions()
                        .position(myLocation)
                        .title(title+" : "+des)

                )
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation,15f))
            }
        }
    }

}
