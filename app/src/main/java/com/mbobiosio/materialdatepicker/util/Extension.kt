package com.mbobiosio.materialdatepicker.util

import android.content.Context
import android.util.TypedValue
import androidx.annotation.AttrRes
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
     */
    val date = Calendar.getInstance()
    /*
    * add two days to current date
    */
    date.add(Calendar.DATE, 2)
    /*
    * convert date to milliseconds
    */
    val max = date.timeInMillis

    /**
     * @param dateValidatorMin long the start point for the calendar
     * @param dateValidatorMax long maximum date allowed
     */
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

/**
 * Create an instance of [getTheme] to return Int.
 *
 * @param attributeResId Int the material theme attribute.
 */
fun Context.getTheme(@AttrRes attributeResId: Int): Int {
    val typedValue = TypedValue()
    if (theme.resolveAttribute(attributeResId, typedValue, true)) {
        return typedValue.data
    }
    throw IllegalArgumentException(resources.getResourceName(attributeResId))
}