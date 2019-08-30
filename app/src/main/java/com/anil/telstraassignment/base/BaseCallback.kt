package com.anil.telstraassignment.base

import androidx.fragment.app.Fragment

interface BaseCallback {

    fun replaceFragment(fragment: Fragment, tag: String, isBackStack: Boolean)

}