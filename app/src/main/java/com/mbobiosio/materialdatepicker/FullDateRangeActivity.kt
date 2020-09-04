package com.mbobiosio.materialdatepicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointForward
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.synthetic.main.activity_full_date_range.*
import java.text.SimpleDateFormat
import java.util.*

class FullDateRangeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_date_range)

        val actionBar =  supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        fullDateRange.setOnClickListener {
            val builder = MaterialDatePicker.Builder.dateRangePicker()
            builder.setTitleText(R.string.material_full_screen_range_title)

            val fullscreenTheme = Util.getTheme(this, R.attr.materialCalendarFullscreenTheme)
            builder.setTheme(fullscreenTheme)

            val constraintsBuilder = CalendarConstraints.Builder()
            val calendar = Calendar.getInstance()
            val dateValidator = DateValidatorPointForward.from(calendar.timeInMillis)
            constraintsBuilder.setValidator(dateValidator)
            builder.setCalendarConstraints(constraintsBuilder.build())

            builder.setInputMode(MaterialDatePicker.INPUT_MODE_CALENDAR)
            val picker = builder.build()
            picker.show(supportFragmentManager, picker.toString())

            picker.addOnPositiveButtonClickListener {

                val timeZone = TimeZone.getDefault()
                val zoneOffset = timeZone.getOffset(Date().time) * -1

                val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.US)
                val startDate = it.first?.let { it1 -> Date(it1 + zoneOffset) }
                val endDate = it.second?.let { it1 -> Date(it1 + zoneOffset) }

                date_info.text = "Start Date ${sdf.format(startDate!!)} :: End Date ${sdf.format(endDate!!)}"
            }
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