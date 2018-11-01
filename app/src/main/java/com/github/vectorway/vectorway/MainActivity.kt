package com.github.vectorway.vectorway

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import com.github.vectorway.vectorway.adapters.BottomBarAdapter
import com.github.vectorway.vectorway.fragments.MembersFragment
import com.github.vectorway.vectorway.fragments.NewsFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*
import android.provider.Settings
import com.google.firebase.database.FirebaseDatabase


class MainActivity : AppCompatActivity() {

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setLogo(R.drawable.logo)
        title = getText(R.string.title_news)

        toolbar.setTitleTextColor(R.color.colorPrimary)
        toolbar.setTitleMargin(70,1,1,1)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        viewPager.setPagingEnabled(false)
        val pagerAdapter = BottomBarAdapter(supportFragmentManager)
        val fragmentMembers = MembersFragment()
        val fragmentNews = NewsFragment()
        pagerAdapter.addFragments(fragmentNews)
        pagerAdapter.addFragments(fragmentMembers)
        viewPager.adapter = pagerAdapter
        viewPager.currentItem = 0

        RequestBootPermission()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {  item ->
        when (item.itemId) {
            R.id.navigation_news -> {
                 viewPager.currentItem = 0
                title = getText(R.string.title_news)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_members -> {
                viewPager.currentItem = 1
                title = getText(R.string.title_members)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun RequestBootPermission() {
        val manufacturer = "xiaomi"

        if (manufacturer.equals(android.os.Build.MANUFACTURER, ignoreCase = true)) {
            val chinaPhonePermission = ReadDataFromPhone("China_Phone_Permission")
            if (chinaPhonePermission === "error" || chinaPhonePermission === "BOOT PERMISSION 0") {
                AlertDialog.Builder(this).setTitle("Требуются права доступа").setMessage("Счастливые обладатели xiaomi должны включить права autostart для " +
                        "данного приложения. Эти права нужны для своевременной доставки пуш уведомлений. " +
                        "Нажмите 'oк' чтобы перейти в настройки безопасности xiaomi и передвиньте ползунок " +
                        "у нашего приложения.").setPositiveButton("ok") { dialog, which ->
                    WriteDataOnPhone("BOOT PERMISSION 1", "China_Phone_Permission")
                    val intent = Intent()
                    intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                    val uri = Uri.fromParts("package", packageName, null)
                    intent.data = uri
                    startActivity(intent)
                }.setNegativeButton("cancel") { dialog, which ->
                    WriteDataOnPhone("BOOT PERMISSION 0", "China_Phone_Permission")
                    dialog.dismiss()
                }.create().show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        FirebaseDatabase.getInstance().goOffline()
    }

    /**
     *
     * @param output строка, которую надо вывести
     * @param filename Имя файла, в который надо вывести
     */
    private fun WriteDataOnPhone(output: String, filename: String): Int {
        try {
            val bw = BufferedWriter(OutputStreamWriter(openFileOutput(filename, Context.MODE_PRIVATE)))
            bw.write(output)
            Log.d("PRINT LOG", output)
            bw.close()
        } catch (e: IOException) {
            Log.d("FILE PRINT ERROR", "can't create/print file")
            return 1
        }

        return 0
    }

    /**
     *
     * @param filename откуда читаем данные
     */
    private fun ReadDataFromPhone(filename: String): String {
        var output = ""
        try {
            val br = BufferedReader(InputStreamReader(openFileInput(filename)))
            output = br.readLine()
            Log.d("READ LOG", output)
            br.close()
        } catch (e: IOException) {
            Log.d("FILE READ ERROR", "Can't open/read file")
            return "error"
        }

        return output
    }

}

