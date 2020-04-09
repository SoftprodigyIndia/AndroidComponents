package com.example.daggerdemokotlin.ui.postfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.daggerdemokotlin.R
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter():RecyclerView.Adapter<PostAdapter.ViewHolder>()  {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_post,parent,false)
        val holder=ViewHolder(view)
        return  holder

    }
    var datas=ArrayList<Post>()
    fun addPost( data:ArrayList<Post>){
        datas.clear()
        datas.addAll(data)
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
        return  datas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])

    }


    inner class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        fun bind(post: Post) {
            itemView.apply {
                this.tvName.text=post.title
            }

        }

    }
}