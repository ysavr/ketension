package com.savr.extensionlibrary

import android.text.Editable
import android.text.Html
import android.util.Patterns
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.StringTokenizer
import java.util.TimeZone

fun String.convertToUIDateFormat(): String {
    val defaultFormat = SimpleDateFormat("yyyy-MM-dd", Locale.forLanguageTag("id-ID"))
    defaultFormat.timeZone = TimeZone.getTimeZone("UTC")
    val result = defaultFormat.parse(this)
    val newFormat = SimpleDateFormat("dd/MM/yyyy", Locale.forLanguageTag("id-ID"))
    return result?.let { newFormat.format(it) }.toString()
}

fun String.convertDateWithMsToIDDateFormat(): String {
    val defaultFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    defaultFormat.timeZone = TimeZone.getTimeZone("UTC")
    val result = defaultFormat.parse(this)
    val newFormat = SimpleDateFormat("dd MMMM yyyy", Locale.forLanguageTag("id-ID"))
    return result?.let { newFormat.format(it) }.toString()
}

fun String.convertDateWithMsToIDDateFormatWithTime(): String {
    val defaultFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    defaultFormat.timeZone = TimeZone.getTimeZone("UTC")
    val result = defaultFormat.parse(this)
    val newFormat = SimpleDateFormat("dd MMMM yyyy, HH:mm", Locale.forLanguageTag("id-ID"))
    return result?.let { newFormat.format(it) }.toString()
}

fun String.convertDateWithMsToIDDayFormat(): String {
    val defaultFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    defaultFormat.timeZone = TimeZone.getTimeZone("UTC")
    val result = defaultFormat.parse(this)
    val day = SimpleDateFormat("EEEE", Locale.forLanguageTag("id-ID"))
    return result?.let { day.format(it) }.toString()
}

fun String.convertSimpleDateToIDDayFormat(): String {
    val defaultFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    defaultFormat.timeZone = TimeZone.getTimeZone("UTC")
    val result = defaultFormat.parse(this)
    val day = SimpleDateFormat("EEEE", Locale.forLanguageTag("id-ID"))
    return result?.let { day.format(it) }.toString()
}

fun String.convertDateToIDDateFormat(): String {
    val defaultFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    defaultFormat.timeZone = TimeZone.getTimeZone("UTC")
    val result = defaultFormat.parse(this)
    val newFormat = SimpleDateFormat("dd MMMM yyyy", Locale.forLanguageTag("id-ID"))
    return result?.let { newFormat.format(it) }.toString()
}

fun String.convertSimpleDateToIDDateFormat(): String {
    val defaultFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    defaultFormat.timeZone = TimeZone.getTimeZone("UTC")
    val result = defaultFormat.parse(this)
    val newFormat = SimpleDateFormat("dd MMMM yyyy", Locale.forLanguageTag("id-ID"))
    return result?.let { newFormat.format(it) }.toString()
}

fun String.convertToTimezoneFormat(): String {
    val defaultFormat = SimpleDateFormat("dd MMMM yyyy", Locale.forLanguageTag("id-ID"))
    defaultFormat.timeZone = TimeZone.getTimeZone("UTC")
    val result = defaultFormat.parse(this)
    val newFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return "${result?.let { newFormat.format(it) }}T${getFullTimeNow()}Z"
}

fun String.getDecimalFormattedString(): String {
    val lst = StringTokenizer(this, ".")
    var str1 = this
    var str2 = ""
    if (lst.countTokens() > 1) {
        str1 = lst.nextToken()
        str2 = lst.nextToken()
    }
    var str3 = ""
    var i = 0
    var j = -1 + str1.length
    if (str1[-1 + str1.length] == '.') {
        j--
        str3 = "."
    }
    var k = j
    while (true) {
        if (k < 0) {
            if (str2.isNotEmpty()) str3 = "$str3.$str2"
            return str3
        }
        if (i == 3) {
            str3 = ",$str3"
            i = 0
        }
        str3 = str1[k].toString() + str3
        i++
        k--
    }
}

fun String.isValidEmailFormat(): Boolean = Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

fun String.toHtml(): String {
    return "${Html.fromHtml(this, Html.FROM_HTML_MODE_COMPACT)}"
}

fun String.filterNumeric() = this.filter { it.isDigit() }