package com.example.experrtmaneger

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View.OnCreateContextMenuListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

import com.example.experrtmaneger.databinding.ActivityMain2Binding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
import java.security.PublicKey

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding

    lateinit var drwerlayout: DrawerLayout
    lateinit var btn1: Button
    lateinit var navview: NavigationView


    lateinit var okay_text: TextView

    lateinit var cancel_text: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val dialog = Dialog(this)



        binding.navview.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.caldnr -> {
                    val intent = Intent(this, CalenderActivity::class.java)
                    startActivity(intent)
                }

                R.id.category -> {
                    val intent = Intent(this, CategoryActivity::class.java)
                    startActivity(intent)
                }

                R.id.payment -> {
                    val intent = Intent(this, PaymentActivity::class.java)
                    startActivity(intent)
                }

                R.id.Rate -> {


                    dialog.setContentView(R.layout.activity_rate);
                    dialog.getWindow()?.setLayout(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    );
                    dialog.setCancelable(false);

                    okay_text = dialog.findViewById(R.id.Yes);
                    cancel_text = dialog.findViewById(R.id.No);
                    okay_text.setOnClickListener {
                        dialog.dismiss();
                        Toast.makeText(this, "okay clicked", Toast.LENGTH_SHORT).show();
                    }


                    cancel_text.setOnClickListener {
                        dialog.dismiss();
                        Toast.makeText(this, "Cancel clicked", Toast.LENGTH_SHORT).show();
                    }

                    dialog.show();

                }

                R.id.reports -> {
                    val intent = Intent(this, ExportedActivity::class.java)
                    startActivity(intent)
                }

                R.id.Share -> {
                    val shareIntent = Intent()
                    shareIntent.action = Intent.ACTION_SEND
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                    startActivity(Intent.createChooser(shareIntent, getString(R.string.send_to)))
                }

                R.id.termsofservice -> {
                    val openURL = Intent(Intent.ACTION_VIEW)
                    openURL.data = Uri.parse("https://www.astartingpoint.com/static/tos.html?psafe_param=1&gclid=Cj0KCQjw8NilBhDOARIsAHzpbLC1EzgkkndxF4KGS2r1Qzjgq6JkbDxKPAmkXDGCvt2DG-fYfFppt5AaAuhHEALw_wcB")
                    startActivity(openURL)
                }

                R.id.privacy -> {
                    val openURL = Intent(Intent.ACTION_VIEW)
                    openURL.data = Uri.parse("https://termify.io/generate-privacy-policy")
                    startActivity(openURL)
                }





            }
            true
        }



        initview()


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_file, menu)
        return true
    }

    private fun initview() {
        binding.addincome.setOnClickListener {
            val intent = Intent(this, AddincomeActivity::class.java)
            startActivity(intent)
        }
        binding.btn1.setOnClickListener {
            binding.drwerlayout.openDrawer(binding.navview)

        }
        binding.AddCtg.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            startActivity(intent)
        }
        binding.drwerlayout.setOnClickListener {
            binding.drwerlayout.closeDrawer(binding.navview)
        }
        binding.calender.setOnClickListener {
            val intent = Intent(this, CalenderActivity::class.java)
            startActivity(intent)
        }
        binding.Premium.setOnClickListener {
            val intent = Intent(this, PremiumActivity::class.java)
            startActivity(intent)


        }

    }
}


