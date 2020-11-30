package dima_merzlov.com.githubsearchrepository.retrofit.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Product (
    @SerializedName("total_count")
    @Expose
    private val totalCount: Int? = null,

    @SerializedName("incomplete_results")
    @Expose
    private val incompleteResults: Boolean? = null,

    @SerializedName("items")
    @Expose
    var items: List<Item>? = null
)