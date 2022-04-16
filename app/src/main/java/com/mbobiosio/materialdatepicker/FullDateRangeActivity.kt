package com.mbobiosio.materialdatepicker

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointForward
import com.google.android.material.datepicker.MaterialDatePicker
import com.mbobiosio.materialdatepicker.util.calendarConstraints
import kotlinx.android.synthetic.main.activity_full_date_range.*
import java.text.SimpleDateFormat
import java.util.*

class FullDateRangeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_date_range)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        fullDateRange.setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.dateRangePicker()
                .setCalendarConstraints(calendarConstraints())
                .setTitleText(R.string.material_full_screen_range_title)
                .setTheme(Util.getTheme(this, R.attr.materialCalendarFullscreenTheme))
                .setInputMode(MaterialDatePicker.INPUT_MODE_CALENDAR)
                .build()

            datePicker.addOnPositiveButtonClickListener {

                val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.US)

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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}