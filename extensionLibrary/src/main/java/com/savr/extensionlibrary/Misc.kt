package com.savr.extensionlibrary

import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun getDateNow():String {
    val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val now = Date()
    return sdf.format(now)
}

fun getDateTimeNow():String {
    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    val now = Date()
    return sdf.format(now)
}

fun getFullTimeNow(): String {
    val sdf = SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault())
    val now = Date()
    return sdf.format(now)
}

fun getTimeNow():String {
    val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    val now = Date()
    return sdf.format(now)
}

fun Long.toDecimalFormat(): String {
    val convert = DecimalFormat("#,###")
    return convert.format(this)
}

fun Float.toDecimalFormat(): String {
    val convert = DecimalFormat("#,###")
    return convert.format(this)
}