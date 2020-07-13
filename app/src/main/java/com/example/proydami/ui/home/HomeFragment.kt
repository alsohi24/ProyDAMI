package com.example.proydami.ui.home

import android.animation.ArgbEvaluator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.example.proydami.CategoriasAdapters.CtgsPagerAdapter
import com.example.proydami.Models.Categoria
import com.example.proydami.R
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    lateinit var colors : Array<Int>
    lateinit var ctgAdap: CtgsPagerAdapter
    lateinit var viewPager : ViewPager
    lateinit var argbEvaluator: ArgbEvaluator

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

            ctgAdap = CtgsPagerAdapter(getListCtgs(), this.context)
            viewPager = vwpg
            viewPager.adapter = ctgAdap
            viewPager.setPadding(130, 0, 130, 0)

            viewPager.setOnPageChangeListener(object: ViewPager.OnPageChangeListener{
                override fun onPageScrollStateChanged(state: Int) {}override fun onPageSelected(position: Int) {}override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

//                    argbEvaluator = ArgbEvaluator().evaluate(positionOffset,
//                        colors[position],3
//                        colors[position + 1]) as ArgbEvaluator
                    println("colors.size : "+ colors.size )
                    println("colors "+ colors[position])
                    println("position: "+ position)
                    if (position < (ctgAdap.count -1) && position < (colors.size - 1)) {
                        viewPager.setBackgroundColor(
                            ArgbEvaluator().evaluate(positionOffset,
                                colors[position],
                                colors[position + 1]) as Int
                        )
                    }
                    else {
                        viewPager.setBackgroundColor(colors[colors.size - 1]);
                    }
                }
            })


        })
        return root
    }

    fun getListCtgs(): ArrayList<Categoria> {

        val lc: ArrayList<Categoria> = ArrayList()
        //Volley
        lc.add(Categoria(R.drawable.brochure,
                    "Brochure",
                   "Brochure is an informative paper document (often also used for advertising) that can be folded into a template"))
        lc.add(Categoria(R.drawable.sticker, "Sticker", "Sticker is a type of label: a piece of printed paper, plastic, vinyl, or other material with pressure sensitive adhesive on one side"))
        lc.add(Categoria(R.drawable.poster, "Poster", "Poster is any piece of printed paper designed to be attached to a wall or vertical surface."))
        lc.add(Categoria(R.drawable.namecard, "Namecard", "Business cards are cards bearing business information about a company or individual."))


        //Colors of Background
        val colors_temp = arrayOf(
            resources.getColor(R.color.color1),
            resources.getColor(R.color.color2),
            resources.getColor(R.color.color3),
            resources.getColor(R.color.color4)
        )
        colors = colors_temp

        return lc
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
        val carouselView = view?.findViewById(R.id.carousel) as? CarouselView
        carouselView?.setImageListener(imageListener)
        carouselView?.setPageCount(carouselImages.size)

    }



}