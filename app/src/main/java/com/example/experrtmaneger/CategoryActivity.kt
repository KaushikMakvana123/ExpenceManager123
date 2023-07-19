package com.example.experrtmaneger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import com.example.experrtmaneger.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {
    lateinit var binding: ActivityCategoryBinding
    lateinit var database: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        database = DatabaseHelper(this, "Database.db", null, 1)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {

        binding.done.setOnClickListener{
            onBackPressed()
        }

        binding.imgback.setOnClickListener{
            onBackPressed()
        }

        binding.btnApply.setOnClickListener {
            var categoryname = binding.edtCategoryName.text.toString()
            if (categoryname.isEmpty()) {
                Toast.makeText(this, "Please Enter Field", Toast.LENGTH_SHORT).show()

            } else {
                database.InsertData(categoryname)
                Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show()
            }



        }

    }
}