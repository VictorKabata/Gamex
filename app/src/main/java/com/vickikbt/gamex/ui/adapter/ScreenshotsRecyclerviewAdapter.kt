package com.vickikbt.gamex.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vickikbt.data.util.DataFormatter.imageUrlScreenshotBig
import com.vickikbt.domain.models.Screenshot
import com.vickikbt.gamex.R
import com.vickikbt.gamex.databinding.RecyclerviewItemScreenshotBinding


class ScreenshotsRecyclerviewAdapter constructor(
    private val context: Context,
    private val screenshots: List<Screenshot>
) : RecyclerView.Adapter<ScreenshotsRecyclerviewViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ScreenshotsRecyclerviewViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding: RecyclerviewItemScreenshotBinding =
            DataBindingUtil.inflate(
                layoutInflater,
                R.layout.recyclerview_item_screenshot,
                parent,
                false
            )

        return ScreenshotsRecyclerviewViewHolder(binding)
    }

    override fun getItemCount() = screenshots.size

    override fun onBindViewHolder(holder: ScreenshotsRecyclerviewViewHolder, position: Int) {
        val screenshot = screenshots[position]

        holder.bind(context, screenshot)

    }
}

class ScreenshotsRecyclerviewViewHolder(private val binding: RecyclerviewItemScreenshotBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(context: Context, screenshot: Screenshot) {
        Glide.with(context).load(imageUrlScreenshotBig(screenshot.imageId))
            .into(binding.imageViewScreenshot)
    }

}