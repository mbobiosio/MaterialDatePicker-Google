package com.mbobiosio.materialdatepicker

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.*
import com.mbobiosio.materialdatepicker.util.calendarConstraints
import kotlinx.android.synthetic.main.activity_date_range.*
import java.text.SimpleDateFormat
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
class DateRangeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_range)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        dateRange.setOnClickListener {
            setupCalendar()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupCalendar() {

        val datePicker = MaterialDatePicker.Builder.dateRangePicker()
            .setCalendarConstraints(calendarConstraints())
            .setTitleText(R.string.material_date_range_title)
            .setTheme(Util.getTheme(this, R.attr.materialCalendarTheme))
            .setInputMode(MaterialDatePicker.INPUT_MODE_CALENDAR)
            .build()

        datePicker.addOnPositiveButtonClickListener {

            val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            val timeZone = TimeZone.getDefault()
            val zoneOffset = timeZone.getOffset(Date().time) * -1

            val startDate = it.first?.let { it1 -> Date(it1 + zoneOffset) }
            val endDate = it.second?.let { it1 -> Date(it1 + zoneOffset) }

            date_info.text =
                "Start Date ${sdf.format(startDate!!)} :: End Date ${sdf.format(endDate!!)}"
        }

        datePicker.show(supportFragmentManager, datePicker.toString())
    }
}