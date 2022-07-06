package com.example.appgerenciadorviagens.componente

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Composable
fun datePicker(label: String, dateModel: LocalDate): LocalDate? {
    val context = LocalContext.current
    val mYear: Int
    val mMonth: Int
    val mDay: Int
    val mCalendar = Calendar.getInstance()

    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)
    mCalendar.time = Date()

    var mDate = remember { mutableStateOf("") }

    var newDate = remember { mutableStateOf("") }

    if (!dateModel.equals(null)) {
        mDate.value = dateModel.toString()
    }

    val mDatePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            mDate.value = "$mDayOfMonth/${mMonth + 1}/$mYear"
            newDate.value = "$mDayOfMonth/${mMonth + 1}/$mYear"
        }, mYear, mMonth, mDay
    )
    mCalendar.set(mYear, mMonth, mDay)


    TextField(
        value = mDate.value,
        onValueChange = {
            mDate.value = it
        },
        singleLine = true,

        enabled = false,
        label = { Text(text = label) },
        modifier = Modifier
            .clickable {
                mDatePickerDialog.show()
            },
    )
    if (!dateModel.equals(newDate.value) && !newDate.value.equals("")) {
        mDate = newDate
    }
    return LocalDate.of(mYear, mMonth, mDay)
}

