package com.mbobiosio.materialdatepicker

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mbobiosio.materialdatepicker.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.datePicker.setOnClickListener {
            startActivity(Intent(this, DatePickerActivity::class.java))
        }

        binding.dateRange.setOnClickListener {
            startActivity(Intent(this, DateRangeActivity::class.java))
        }

        binding.fullRangePicker.setOnClickListener {
            startActivity(Intent(this, FullDateRangeActivity::class.java))
        }

    }


}
