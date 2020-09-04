package com.mbobiosio.materialdatepicker

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        date_picker.setOnClickListener {
            startActivity(Intent(this, DatePickerActivity::class.java))
        }

        date_range.setOnClickListener {
            startActivity(Intent(this, DateRangeActivity::class.java))
        }

        full_range_picker.setOnClickListener {
            startActivity(Intent(this, FullDateRangeActivity::class.java))
        }

    }


}
