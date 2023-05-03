package com.alierkoc.filmlerv1.ui.activies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alierkoc.filmlerv1.R
import com.alierkoc.filmlerv1.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val sp = getSharedPreferences("Entry Information", MODE_PRIVATE)
        val userName = sp.getString("userName", "no value")


        if (userName=="no value") {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, SelectionActivity::class.java)
            startActivity(intent)
        }
    }
}
