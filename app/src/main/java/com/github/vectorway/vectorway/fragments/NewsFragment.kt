package com.github.vectorway.vectorway.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.vectorway.vectorway.R
import com.github.vectorway.vectorway.adapters.NewsRecyclerViewAdapter
import com.github.vectorway.vectorway.data.NewsData
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment: Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val listOfNewsData: ArrayList<NewsData> = ArrayList()
        val news1 = NewsData("https://pp.userapi.com/c850720/v850720981/2db47/GThVanwPkeM.jpg",
            "Контест!",
            "Наше сообщество проводит первый контест! Может именно ты станешь лучшим!",
            true,
            "УЧАСТВУЮ!",
            "НЕ УЧАСТВУЮ",
            "https://vk.com/itvectorsoc?w=wall-120211608_455")
        val news2 = NewsData("https://pp.userapi.com/c849528/v849528096/90bb8/-QD2buoWM_Y.jpg",
            "СТРИМ!!!",
            "Как вы относитесь к стримам?\n" +
                    "Есть мысль провести сегодня в 20:00 небольшой(часа полтора) ламповый стрим с Тимом, чтобы показать пример разработки небольшого Android приложения",
            false,
            null,
            null,
            "https://vk.com/away.php?to=https%3A%2F%2Fwww.twitch.tv%2Ftimtimdotqz&cc_key=")
        val news3 = NewsData("https://i.ytimg.com/vi/eFK37RBsrUY/maxresdefault.jpg",
            "waywayway",
            "sdasfdfdfsdfsd")
        listOfNewsData.add(news1)
        listOfNewsData.add(news2)
        listOfNewsData.add(news3)
        val layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        val recyclerViewAdapterNews: RecyclerView.Adapter<*>
        recylerViewNews.layoutManager = layoutManager
        recyclerViewAdapterNews = NewsRecyclerViewAdapter(listOfNewsData)
        recylerViewNews.adapter = recyclerViewAdapterNews
    }

}