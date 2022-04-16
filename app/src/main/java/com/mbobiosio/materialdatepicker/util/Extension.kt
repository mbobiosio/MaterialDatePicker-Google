package com.mbobiosio.materialdatepicker.util

import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.CompositeDateValidator
import com.google.android.material.datepicker.DateValidatorPointBackward
import com.google.android.material.datepicker.DateValidatorPointForward
import java.util.*

/*
* Created by Mbuodile Obiosio on Apr 16, 2022.
* Twitter: @cazewonder
* Nigeria
*/
fun calendarConstraints(): CalendarConstraints {
    /**
     * Create an instance of [CalendarConstraints].
     *
     */
    val date = Calendar.getInstance()
    date.add(Calendar.DATE, 2)
    val max = date.timeInMillis

    val dateValidatorMin = DateValidatorPointForward.now()
    val dateValidatorMax = DateValidatorPointBackward.before(max)

    val listValidators = ArrayList<CalendarConstraints.DateValidator>()
    listValidators.apply {
        //Limit start date
        //add(dateValidatorMin)
        //Limit max date
        //add(dateValidatorMax)
    }
    val validators = CompositeDateValidator.allOf(listValidators)

    return CalendarConstraints.Builder()
        .setValidator(validators)
        .build()
}