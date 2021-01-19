package com.vickikbt.data.util

object Constants {

    const val AUTH_BASE_URL = "https://id.twitch.tv/oauth2/"

    const val BASE_URL = "https://api.igdb.com/v4/"

    val currentTimeMills = System.currentTimeMillis()

    val RELEASED =
        "name,cover.image_id,first_release_date,game_modes.name,genres.name,platforms.*,involved_companies.company.name,player_perspectives.name,screenshots.image_id,similar_games.name, similar_games.cover.image_id,storyline,summary,total_rating,videos.video_id;where cover.image_id!=null & rating>70 & first_release_date<1610824393;sort first_release_date desc;limit 50;"
    //TODO: Better implementation

    val UNRELEASED="name,cover.image_id,first_release_date,game_modes.name,genres.name,platforms.*,involved_companies.company.name,player_perspectives.name,screenshots.image_id,similar_games.name, similar_games.cover.image_id,storyline,summary,total_rating,videos.video_id;where cover.image_id!=null &  first_release_date > 1610824393;sort first_release_date asc;limit 100;"

    const val GAME_DETAIL="name,cover.image_id,first_release_date,game_modes.name,genres.name,platforms.*,involved_companies.company.name,player_perspectives.name,screenshots.image_id,similar_games.name, similar_games.cover.image_id,storyline,summary,total_rating,videos.video_id;where id="

    const val LIMIT = "50;"

    const val FILTER = ""

    const val CLIENT_ID = "0kp6w12pfx3g1fn1whmv80ub79mylr"

    const val CLIENT_SECRET =
        "2bfc9a23vq7ngva56xbxr33by7sumg" //TODO: Remove client id and secret later

}