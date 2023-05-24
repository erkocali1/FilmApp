package com.alierkoc.filmlerv1.ui.activies

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.alierkoc.filmlerv1.R
import com.alierkoc.filmlerv1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var sp:SharedPreferences
    private lateinit var binding:ActivityMainBinding
    private lateinit var galleryLauncher: ActivityResultLauncher<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sp=getSharedPreferences("entryInformation", MODE_PRIVATE)
        setOnClickLister()



    }

    private fun setOnClickLister(){
        binding.signUp.setOnClickListener {

            val userName=binding.userName.text.toString()
            val userNameSize=binding.userName.text.length

            if (userName != "" && userNameSize > 2 ){

//            println("sizin ki $userNameSize")

                val editor=sp.edit()
                editor.putString("userName",userName)
                editor.apply()


                startActivity(Intent(this,SelectionActivity::class.java))
            }

            else{
                Toast.makeText(this, "Lütfen Kullanıcı Adı ve Fotograf Giriniz", Toast.LENGTH_SHORT).show()
            }

        }

    }



}