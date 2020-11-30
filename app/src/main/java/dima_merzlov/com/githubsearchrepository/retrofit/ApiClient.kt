package dima_merzlov.com.githubsearchrepository.retrofit

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory




class ApiClient {
    companion object{
        private var retrofit: Retrofit? =null
        fun getRetrofit(): GetRequest {
            if(retrofit==null){
                Log.i("LOG_I_EROR","ApiClient")
                retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                Log.i("LOG_I_EROR","ApiClient2")
            }

            return retrofit!!.create(GetRequest::class.java)
        }
    }
}