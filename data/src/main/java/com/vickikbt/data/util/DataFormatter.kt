package com.vickikbt.data.util

import android.util.Log
import java.util.*

object DataFormatter {

    private const val imageUrlPrefix = "https://images.igdb.com/igdb/image/upload/t_"

    fun imageUrlx1080(imageId: String?) = imageUrlPrefix + "1080/$imageId.jpg" //1080p

    fun imageUrlx720(imageId: String?) = imageUrlPrefix + "720p/$imageId.jpg" //720p

    fun imageUrlScreenshotHuge(imageId: String?) =
        imageUrlPrefix + "screenshot_huge/$imageId.jpg" //1280 x 720

    fun imageUrlScreenshotBig(imageId: String?) =
        imageUrlPrefix + "screenshot_big/$imageId.jpg" //889 x 500

    fun imageUrlScreenshotMedium(imageId: String?) =
        imageUrlPrefix + "screenshot_med/$imageId.jpg" //569 x 320

    fun imageUrlLogoMedium(imageId: String?) = imageUrlPrefix + "logo_med/$imageId.jpg" //284 x 160

}