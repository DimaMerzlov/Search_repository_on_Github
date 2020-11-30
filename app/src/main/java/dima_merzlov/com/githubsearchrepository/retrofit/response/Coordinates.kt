package dima_merzlov.com.githubsearchrepository.retrofit.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Coordinates {
    @SerializedName("latitude")
    @Expose
    var latitude: String? = null

    @SerializedName("longitude")
    @Expose
    var longitude: String? = null
}