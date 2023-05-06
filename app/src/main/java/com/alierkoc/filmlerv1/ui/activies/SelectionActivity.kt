package com.alierkoc.filmlerv1.ui.activies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alierkoc.filmlerv1.R
import com.alierkoc.filmlerv1.databinding.ActivitySelectionBinding

class SelectionActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}