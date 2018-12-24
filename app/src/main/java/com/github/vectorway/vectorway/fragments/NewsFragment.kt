package com.github.vectorway.vectorway.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.vectorway.vectorway.R
import com.github.vectorway.vectorway.adapters.NewsRecyclerViewAdapter
import com.github.vectorway.vectorway.data.NewsData
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment: Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var listOfNewsData: ArrayList<NewsData> = ArrayList()
        val recyclerViewAdapterNews = NewsRecyclerViewAdapter(listOfNewsData)

        val myRef: DatabaseReference = FirebaseDatabase.getInstance().getReference()

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val t = object : GenericTypeIndicator<ArrayList<NewsData>>() {}
                listOfNewsData = dataSnapshot.child("events").getValue<ArrayList<NewsData>>(t)!!

                Log.d("MyActivityMain", "Value is: " + listOfNewsData.toString())


                recyclerViewAdapterNews.UpdateList(listOfNewsData)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("FAILED CONECTION", "Failed to read value.")
            }
        })


        val layoutManager = LinearLayoutManager(activity,RecyclerView.VERTICAL,false)
        recylerViewNews.layoutManager = layoutManager
        recylerViewNews.adapter = recyclerViewAdapterNews
    }
}