package dima_merzlov.com.githubsearchrepository

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import dima_merzlov.com.githubsearchrepository.adapter.MyAdapter
import dima_merzlov.com.githubsearchrepository.retrofit.ApiClient
import dima_merzlov.com.githubsearchrepository.retrofit.ORDER_DESC
import dima_merzlov.com.githubsearchrepository.retrofit.SORT_BY_STARS
import dima_merzlov.com.githubsearchrepository.retrofit.response.Item
import dima_merzlov.com.githubsearchrepository.retrofit.response.Product
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val LOG_I_EROR = "LOG_I_EROR"
    private var listOfItems: List<Item> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val searchText = searchRepository.text.toString()
        Log.i(LOG_I_EROR, "step 1")
        /* var apiService=ApiClient.getRetrofit()
         //var some=apiService.getRepository()
         //some.body()?.get(0)?.items?.get(0)?.id*/
        //val api=ApiClient.getRetrofit().getUser()
        Log.i(LOG_I_EROR, "step 3")
        searchButton.setOnClickListener {
            var text=searchRepository.text.toString()
            var apiService = ApiClient.getRetrofit()
            var listItem = apiService.getRepository(text, SORT_BY_STARS, ORDER_DESC)

            listItem.enqueue(object : Callback<Product> {
                override fun onResponse(call: Call<Product>, response: Response<Product>) {
                    if (response.code() == 200) {
                        Log.i(LOG_I_EROR, "response.code")
                        val myResponse = response.body()
                        Log.i(LOG_I_EROR, "response.code" + response.body().toString())
                        val list = myResponse?.items
                        recyclerView.apply {
                            var myAdapter=MyAdapter()
                            if (list != null) {
                                myAdapter.setListItem(list)
                            }
                            adapter=myAdapter
                            layoutManager = LinearLayoutManager(this@MainActivity)
                            Log.i(LOG_I_EROR, "step 2")
                        }

                    }
                }

                override fun onFailure(call: Call<Product>, t: Throwable) {
                    Log.i(LOG_I_EROR, t.toString())
                }

            })

        }
    }
}