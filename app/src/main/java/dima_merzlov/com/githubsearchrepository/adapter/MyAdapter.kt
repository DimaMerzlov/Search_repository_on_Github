package dima_merzlov.com.githubsearchrepository.adapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dima_merzlov.com.githubsearchrepository.R
import dima_merzlov.com.githubsearchrepository.retrofit.response.Item

class MyAdapter(): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var list: List<Item> = ArrayList()

    fun setListItem(listItem:List<Item>){
        list=listItem
        notifyDataSetChanged()
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var item_tv=view.findViewById<TextView>(R.id.tv_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val repository=list.get(position)
        holder.item_tv.text=repository.fullName+" "+position
    }

    override fun getItemCount(): Int {
        return list.size
    }
}