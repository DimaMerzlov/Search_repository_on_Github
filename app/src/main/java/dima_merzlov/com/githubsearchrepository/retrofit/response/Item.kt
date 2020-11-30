package dima_merzlov.com.githubsearchrepository.retrofit.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Item (
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("full_name")
    @Expose
    var fullName: String? = null
)