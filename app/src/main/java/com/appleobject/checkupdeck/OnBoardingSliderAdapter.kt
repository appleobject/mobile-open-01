package com.appleobject.checkupdeck

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter

class OnBoardingSliderAdapter(private val context: Context) : PagerAdapter() {

    private val images  = arrayOf(
        R.drawable.doctors_team,

    )


    private val headings = arrayOf(
        context.getString(R.string.on_boarding_heading_1),

    )

    private val descriptions = arrayOf(
        context.getString(R.string.on_boarding_description_1),

    )

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = LayoutInflater.from(context).inflate(R.layout.on_boarding_slides_layout,container,false)

        val imageView = layoutInflater.findViewById<ImageView>(R.id.img_slider)
        val textTitle = layoutInflater.findViewById<TextView>(R.id.txt_slider_heading)
        val txtDescription = layoutInflater.findViewById<TextView>(R.id.txt_slider_description)

        imageView.setImageResource(images[position])
        textTitle.text = headings[position]
        txtDescription.text = descriptions[position]

        container.addView(layoutInflater)

        return layoutInflater
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }

}