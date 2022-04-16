package com.mbobiosio.materialdatepicker

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import com.mbobiosio.materialdatepicker.databinding.ActivityFullDateRangeBinding
import com.mbobiosio.materialdatepicker.util.calendarConstraints
import com.mbobiosio.materialdatepicker.util.getTheme
import java.text.SimpleDateFormat
import java.util.*

class FullDateRangeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFullDateRangeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        binding.fullDateRange.setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.dateRangePicker()
                .setCalendarConstraints(calendarConstraints())
                .setTitleText(R.string.material_full_screen_range_title)
                .setTheme(getTheme(R.attr.materialCalendarFullscreenTheme))
                .setInputMode(MaterialDatePicker.INPUT_MODE_CALENDAR)
                .build()

            datePicker.addOnPositiveButtonClickListener {

                val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.US)

                val timeZone = TimeZone.getDefault()
                val zoneOffset = timeZone.getOffset(Date().time) * -1

                val startDate = it.first?.let { it1 -> Date(it1 + zoneOffset) }
                val endDate = it.second?.let { it1 -> Date(it1 + zoneOffset) }

                binding.dateInfo.text =
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