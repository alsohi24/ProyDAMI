package com.example.proydami.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.proydami.R
import com.example.proydami.R.id.carousel
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.*
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)


        homeViewModel.text.observe(this, Observer {
            setCarousel()
        })
        return root
    }



    fun setCarousel(){
        var carouselImages = intArrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3
        )
        var imageListener: ImageListener = object : ImageListener {
            override fun setImageForPosition(position: Int, imageView: ImageView) {
                // You can use Glide or Picasso here
                imageView.setImageResource(carouselImages[position])
            }
        }
        val carouselView = view?.findViewById(carousel) as? CarouselView;
        carouselView?.setImageListener(imageListener);
        carouselView?.setPageCount(carouselImages.size);


    }



}