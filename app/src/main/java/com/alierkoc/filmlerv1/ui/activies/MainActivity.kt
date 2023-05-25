package com.alierkoc.filmlerv1.ui.activies

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.alierkoc.filmlerv1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var sp:SharedPreferences
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sp=getSharedPreferences("entryInformation", MODE_PRIVATE)
        setOnClickLister()


    }

    private fun setOnClickLister(){


        binding.selectImage.setOnClickListener {
            pickImage()
        }


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

    private fun  pickImage(){

        val intent=Intent(Intent.ACTION_GET_CONTENT)
        intent.type="image/*"
        resultLauncher.launch(intent)

    }
    var resultLauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode==Activity.RESULT_OK){
            val data:Intent?=it.data
            data?.data?.let { imageUri ->
                val selectionIntent = Intent(this, SelectionActivity::class.java)
                selectionIntent.putExtra("imageUri", imageUri.toString())
                startActivity(selectionIntent)
            }

        }
    }

}
