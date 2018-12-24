package com.github.vectorway.vectorway.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.vectorway.vectorway.R
import com.github.vectorway.vectorway.adapters.MembersRecycleViewAdapter
import com.github.vectorway.vectorway.data.MemberData
import kotlinx.android.synthetic.main.fragment_members.*

class MembersFragment: Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_members, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val listOfMemberData: ArrayList<MemberData> = ArrayList()
        val member1 = MemberData("https://www.biography.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cg_face%2Cq_auto:good%2Cw_300/MTE5NDg0MDU1MDY3MDY3OTE5/freddie-mercury-9406228-1-402.jpg",
            "Фронтэнд")
        listOfMemberData.add(member1)
        val layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL,false)
        val recyclerViewAdapterMembers: RecyclerView.Adapter<*>
        recylerViewMembers.layoutManager = layoutManager
        recyclerViewAdapterMembers = MembersRecycleViewAdapter(listOfMemberData)
        recylerViewMembers.adapter = recyclerViewAdapterMembers
    }

}