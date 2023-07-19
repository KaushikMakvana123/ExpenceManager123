package com.example.experrtmaneger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.example.experrtmaneger.databinding.ActivityAddincomeBinding
import com.example.experrtmaneger.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {
    lateinit var database: DatabaseHelper

    var Modelist = ArrayList<modelclas1>()
    lateinit var binding: ActivityPaymentBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = DatabaseHelper(this, "Database.db", null, 1)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {
        binding.btnApply.setOnClickListener {
            var modeName = binding.edtCategoryName.text.toString()
            if (modeName.isEmpty()) {
                Toast.makeText(this, "Please Enter Field", Toast.LENGTH_SHORT).show()

            } else {
                database.Insertmoddata(modeName)
                Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show()
            }
        }
    }
}