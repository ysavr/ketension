package com.savr.extensionlibrary

import androidx.fragment.app.Fragment

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Fragment.toast(message: String, isLong: Boolean = false) {
    requireActivity().createToast(message, isLong)
}