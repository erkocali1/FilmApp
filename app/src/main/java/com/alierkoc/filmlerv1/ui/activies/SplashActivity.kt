package com.alierkoc.filmlerv1.ui.activies

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alierkoc.filmlerv1.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var sp:SharedPreferences
    private lateinit var binding: ActivitySplashBinding
    private var userName=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        sp = getSharedPreferences("entryInformation", MODE_PRIVATE)
        userName = sp.getString("userName", "no value").toString()
        entryCheck()



    }

    fun entryCheck(){
        if (userName=="no value") {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, SelectionActivity::class.java)
            startActivity(intent)
        }

    }
}
