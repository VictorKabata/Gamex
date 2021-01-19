package com.vickikbt.gamex.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.vickikbt.data.util.DataFormatter.imageUrlScreenshotMedium
import com.vickikbt.data.util.DataFormatter.imageUrlx720
import com.vickikbt.domain.models.Game
import com.vickikbt.gamex.R
import com.vickikbt.gamex.databinding.ViewpagerItemHomeBinding
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlin.random.Random

class HomeViewPagerAdapter constructor(
    private val context: Context,
    private val games: List<Game>
) : PagerAdapter() {

    override fun getCount() = 3 //games.size

    override fun isViewFromObject(view: View, `object`: Any) = view.equals(`object`)

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = LayoutInflater.from(context)
        val binding: ViewpagerItemHomeBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.viewpager_item_home, container, false)

        //val randomPosition = Random(position).nextInt()
        val game = games[position]

        Glide.with(context).load(imageUrlScreenshotMedium(game.screenShots?.get(0)?.imageId))
            .apply(RequestOptions.bitmapTransform(BlurTransformation(1, 2)))
            .into(binding.imageViewHomeSliderBackground)

        Glide.with(context).load(imageUrlx720(game.cover!!.imageId))
            .into(binding.imageViewHomeSliderCover)

        binding.textViewHomeSlider.text = game.name

        container.addView(binding.root, 0)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}