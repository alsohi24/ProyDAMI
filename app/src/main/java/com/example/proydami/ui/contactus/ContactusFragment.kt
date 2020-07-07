package com.example.proydami.ui.contactus

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.InflateException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.proydami.R
import com.google.android.gms.maps.*

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_contactus.view.*


class ContactusFragment : Fragment() {

    private lateinit var contactusViewModel: ContactusViewModel

    private lateinit var mMap: GoogleMap
    //var mapView: MapView? = null
    var root: View? = null

    private var mapReady = false

//    companion object {
//        var mapFragment : SupportMapFragment?=null
//
//        val TAG: String = MapFragment::class.java.simpleName
//        fun newInstance() = MapFragment()
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


            if (root != null) {
                var parent:ViewGroup = root?.getParent() as ViewGroup;
                if (parent != null)
                    parent.removeView(root);
            }
            try {
                root = inflater.inflate(R.layout.fragment_contactus, container, false)
            } catch (e: InflateException) {
                val toast = Toast.makeText(activity, e.message, Toast.LENGTH_LONG)
                toast.show()
            }

        contactusViewModel = ViewModelProviders.of(this).get(ContactusViewModel::class.java)

        var mapFragment = fragmentManager?.findFragmentById(R.id.contactMap) as SupportMapFragment?

        mapFragment?.getMapAsync {
                googleMap ->
            //mMap = googleMap
            //mapReady = true
            val sydney = LatLng(-34.0, 151.0)
            googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
            //googleMap.re
            //setValuesonMapReady()
        }

        //contactusViewModel.text.observe(this, Observer {
            //textView.text = it
//            val mapFragment = supportFragmentManager
//                .findFragmentById(R.id.contactMap) as SupportMapFragment
//            mapFragment.getMapAsync(this)
        //})
        return root
    }

    fun setValuesonMapReady() {
        //mMap = gm

        println(mMap)
        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }


//    override fun onMapReady(gm: GoogleMap) {
//        mMap = gm
//
//        // Add a marker in Sydney and move the camera
//        val sydney = LatLng(-34.0, 151.0)
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
//    }


}