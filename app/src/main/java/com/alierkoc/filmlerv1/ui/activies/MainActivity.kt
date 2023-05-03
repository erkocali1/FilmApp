package com.alierkoc.filmlerv1.ui.activies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.alierkoc.filmlerv1.R
import com.alierkoc.filmlerv1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sp=getSharedPreferences("Entry Information", MODE_PRIVATE)


        binding.signUp.setOnClickListener {

            val userName=binding.userName.text.toString()
            val userNameSize=binding.userName.text.length

            if (userName != "" && userNameSize > 2 ){

//            println("sizin ki $userNameSize")

                val editor=sp.edit()
                editor.putString("userName",userName)
                editor.commit()


                startActivity(Intent(this,SelectionActivity::class.java))
            }

            else{
                Toast.makeText(this, "Lütfen Kullanıcı Adı ve Fotograf Giriniz", Toast.LENGTH_SHORT).show()
            }

        }
    }
}