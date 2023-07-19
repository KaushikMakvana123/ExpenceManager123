package com.example.experrtmaneger

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.experrtmaneger.databinding.ActivitySpalshBinding

class SpalshActivity : AppCompatActivity() {

    lateinit var  binding: ActivitySpalshBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpalshBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {


        Handler().postDelayed(
            {
                val i = Intent(this@SpalshActivity, MainActivity::class.java)
                startActivity(i)
                finish()
            }, 5000)

    }
}
