package com.c0d3v9.adopet.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.c0d3v9.adopet.R
import com.c0d3v9.adopet.model.Post

class PostAdapter(
    private  val context:Context,
    private val posts:List<Post>,
    private val itemClickListener: ItemClickListener
) :RecyclerView.Adapter<PostAdapter.ViewHolder>()
{

    interface ItemClickListener{
        fun onItemClick(post:Post)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_post,parent,false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount() = posts.size

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        private val  tvid = itemView.findViewById<TextView>(R.id.petName)
        private val  tvtitle = itemView.findViewById<TextView>(R.id.petAge)
        private val  tvbody = itemView.findViewById<TextView>(R.id.petLocation)
        fun bind(post:Post){
            tvid.text = "Post id is : ${post.id}"
            tvtitle.text = post.title
            tvbody.text = post.body
            itemView.setOnClickListener {
                itemClickListener.onItemClick(post)
            }
        }
    }


}