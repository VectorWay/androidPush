package com.github.vectorway.vectorway.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import java.util.ArrayList
import android.content.Intent
import android.net.Uri
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.github.vectorway.vectorway.R
import com.github.vectorway.vectorway.data.NewsData


class NewsRecyclerViewAdapter(private val Datalist: ArrayList<NewsData>) : RecyclerView.Adapter<NewsRecyclerViewAdapter.MyViewHolder>() {
    var listNews: ArrayList<NewsData> = Datalist
    var context: Context? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_news, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Picasso.get().load(listNews[position].imageUrl).resize(1200,700).centerCrop().into(holder.imageNews)
        holder.textNews.text = listNews[position].newsText
        holder.newsTitle.text = listNews[position].newsTitle
        if(listNews[position].isChoose){
            holder.textBtnAgree.text = listNews[position].textBtnAgree
            holder.textBtnDisagree.text = listNews[position].textBtnDisagree
        }
        else{
            holder.textBtnAgree.visibility = View.GONE
            holder.textBtnDisagree.visibility = View.GONE
        }
        if(listNews[position].cardLinkToNews!=null) {
            holder.cardViewClick.setOnClickListener {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(listNews[position].cardLinkToNews))
                context!!.startActivity(browserIntent)
            }
        }
    }

    override fun getItemCount(): Int {
        return listNews.size
    }

    fun UpdateList(newData : ArrayList<NewsData>){
        listNews = newData
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var imageNews: ImageView
        internal var textNews: TextView
        internal var newsTitle: TextView
        internal var textBtnAgree: Button
        internal var textBtnDisagree: Button
        internal var cardViewClick: CardView

        init {
            imageNews = itemView.findViewById(R.id.image_news)
            textBtnAgree = itemView.findViewById(R.id.yes_button)
            textBtnDisagree = itemView.findViewById(R.id.no_button)
            textNews = itemView.findViewById(R.id.text_news)
            newsTitle = itemView.findViewById(R.id.news_title)
            cardViewClick = itemView.findViewById(R.id.card_view_news)
        }
    }
}