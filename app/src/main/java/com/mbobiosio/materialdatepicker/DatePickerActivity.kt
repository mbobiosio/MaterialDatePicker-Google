package com.mbobiosio.materialdatepicker

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointForward
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.synthetic.main.activity_date_picker.*
import java.text.SimpleDateFormat
import java.util.*

class DatePickerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_picker)

        val actionBar =  supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        datePicker.setOnClickListener {
            val builder = MaterialDatePicker.Builder.datePicker()
            builder.setTitleText(R.string.material_date_picker_title)

            val constraintsBuilder = CalendarConstraints.Builder()
            val calendar = Calendar.getInstance()
            val dateValidator = DateValidatorPointForward.from(calendar.timeInMillis)
            constraintsBuilder.setValidator(dateValidator)
            builder.setCalendarConstraints(constraintsBuilder.build())

            val picker = builder.build()
            picker.show(supportFragmentManager, picker.toString())

            picker.addOnPositiveButtonClickListener {

                val timeZone = TimeZone.getDefault()
                val zoneOffset = timeZone.getOffset(Date().time) * -1
                val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.US)
                val date = Date(it + zoneOffset)

                date_info.text = sdf.format(date)
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