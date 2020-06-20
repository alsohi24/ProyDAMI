package com.example.proydami.ui.contactus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.proydami.R
import com.google.android.gms.maps.*

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class ContactusFragment : Fragment(), OnMapReadyCallback {

    private lateinit var contactusViewModel: ContactusViewModel

    private lateinit var mMap: GoogleMap
    var mapView: MapView? = null

    companion object {
        var mapFragment : SupportMapFragment?=null

        val TAG: String = MapFragment::class.java.simpleName
        fun newInstance() = MapFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contactusViewModel =
            ViewModelProviders.of(this).get(ContactusViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_contactus, container, false)

        mapFragment = fragmentManager?.findFragmentById(R.id.contactMap) as SupportMapFragment?
        mapFragment?.getMapAsync(this)

        //mapView = root.findViewById(R.id.contactMap)
       // mapView.onCreate(savedInstanceState)
//        if (mapView != null) {
//            mMap = mapView.getMap
//            mMap.getUiSettings().setMyLocationButtonEnabled(false)
//            mMap.setMyLocationEnabled(true)
//            val cameraUpdate = CameraUpdateFactory.newLatLngZoom(LatLng(43.1, -87.9), 10f)
//            mMap.animateCamera(cameraUpdate)
//        }
        contactusViewModel.text.observe(this, Observer {
            //textView.text = it
//            val mapFragment = supportFragmentManager
//                .findFragmentById(R.id.contactMap) as SupportMapFragment
//            mapFragment.getMapAsync(this)
        })
        return root
    }

    override fun onMapReady(gm: GoogleMap) {
        mMap = gm

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }


}