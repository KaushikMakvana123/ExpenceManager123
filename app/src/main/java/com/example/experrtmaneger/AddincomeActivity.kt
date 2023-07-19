package com.example.experrtmaneger

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import android.widget.TextView
import com.example.e2345.Adapter.CatAdapter
import com.example.experrtmaneger.databinding.ActivityAddincomeBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AddincomeActivity : AppCompatActivity() {

    lateinit var database: DatabaseHelper
    lateinit var binding: ActivityAddincomeBinding
    var Categorylist = ArrayList<modelclass>()
    var modelist = ArrayList<modelclas1>()

    lateinit var spinner: Spinner
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddincomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()
    }

    private fun initview() {

   binding.imgback.setOnClickListener{
    onBackPressed()
}

        binding.done.setOnClickListener{
            onBackPressed()
        }

        val myCalendar = Calendar.getInstance()
        val datapicker = DatePickerDialog.OnDateSetListener { view, year, month, dayofmonth ->

            myCalendar.set(Calendar.DAY_OF_MONTH, dayofmonth)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.YEAR, year)
            updateLabal(myCalendar)

        }


        binding.tvDate.setOnClickListener {

            DatePickerDialog(
                this, datapicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }



        //for time picker
        binding.tvTime.setOnClickListener {

            val calendar = Calendar.getInstance()
            val currentHour = calendar.get(Calendar.HOUR_OF_DAY)
            val currentMinute = calendar.get(Calendar.MINUTE)

            val textView: TextView = findViewById(R.id.tvTime)


            val timePickerDialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
                    val selectedTime = String.format("%02d:%02d", currentHour, minute)
                    textView.text = selectedTime
                },
                currentHour,
                currentMinute,
                false
            )

            timePickerDialog.show()

        }

        database = DatabaseHelper(this, "Database.db", null, 1)
        Categorylist = database.displayCategory()
        var adapter = CatAdapter(this, Categorylist)
        binding.spinner.adapter = adapter


        modelist = database.Dispalaymode()

        var adpter2 = Modeadpter(this, modelist)
        binding.spinnermode.adapter = adpter2


    }

    fun updateLabal(myCalendar: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        binding.tvDate.setText(sdf.format(myCalendar.time))
    }
}
