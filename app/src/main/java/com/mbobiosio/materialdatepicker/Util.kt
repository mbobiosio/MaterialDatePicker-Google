package com.mbobiosio.materialdatepicker

import android.content.Context
import android.util.TypedValue
import androidx.annotation.AttrRes

object Util {

    fun getTheme(context: Context, @AttrRes attributeResId: Int): Int {
        val typedValue = TypedValue()
        if (context.theme.resolveAttribute(attributeResId, typedValue, true)) {
            return typedValue.data
        }
        throw IllegalArgumentException(context.resources.getResourceName(attributeResId))
    }

}