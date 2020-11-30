package dima_merzlov.com.githubsearchrepository.retrofit

import dima_merzlov.com.githubsearchrepository.retrofit.response.Coordinates
import dima_merzlov.com.githubsearchrepository.retrofit.response.Product
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

val BASE_URL = "https://api.github.com/"
//https://api.github.com/search/repositories?q=tetris+language:assembly&sort=stars&order=desc
val LANGUEGE_CODE=""
val SORT_BY_STARS="stars"
val ORDER_DESC="desc"
interface GetRequest {

    @GET("search/repositories?")
    fun getRepository(
        @Query("q") repository: String,
        @Query("sort") sort: String,
        @Query("order") order: String,
    ): Call<Product>

    @GET
    fun getUser():Call<Coordinates>
}