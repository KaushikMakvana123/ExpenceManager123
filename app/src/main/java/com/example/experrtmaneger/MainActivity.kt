
package com.example.experrtmaneger

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    lateinit var termsofservice : TextView
    lateinit var privcy : TextView
    lateinit var permision : TextView
    lateinit var btn1 : CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initview()
    }

    private fun initview() {
        termsofservice=findViewById(R.id.termsofservice)
        privcy=findViewById(R.id.privcy)
        btn1=findViewById(R.id.btn1)
        permision=findViewById(R.id.permision)

        termsofservice.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.youtube.com/watch?v=pxNQInZbFZQ")
            startActivity(openURL)
        }
        privcy.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.oyorooms.com/")
            startActivity(openURL)
        }

        permision.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.youtube.com/watch?v=5AcxgLnNe9s")
            startActivity(openURL)
        }
        btn1.setOnClickListener{
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    }
}