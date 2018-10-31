package com.github.vectorway.vectorway.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.github.vectorway.vectorway.R
import com.github.vectorway.vectorway.data.MemberData
import com.squareup.picasso.Picasso
import java.util.ArrayList

class MembersRecycleViewAdapter(private val DataList: ArrayList<MemberData>) : RecyclerView.Adapter<MembersRecycleViewAdapter.MyViewHolder>() {
    var context: Context? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_member, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Picasso.get().load(DataList[position].imageUrl).resize(50,50).into(holder.imageMember)
        holder.textMember.text = DataList[position].memberText
    }

    override fun getItemCount(): Int {
        return DataList.size
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var imageMember: ImageView
        internal var textMember: TextView

        init {
            imageMember = itemView.findViewById(R.id.image_member_card)
            textMember = itemView.findViewById(R.id.text_member_card)
        }
    }
}