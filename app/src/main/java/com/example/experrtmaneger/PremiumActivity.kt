package com.example.experrtmaneger
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.experrtmaneger.databinding.ActivityAddincomeBinding
import com.example.experrtmaneger.databinding.ActivityPremiumBinding

class PremiumActivity : AppCompatActivity() {
    lateinit var binding: ActivityPremiumBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPremiumBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {
        binding.buyplan.setOnClickListener{
            onBackPressed()

        }
        binding.imgback.setOnClickListener{
            onBackPressed()

        }

    }
}