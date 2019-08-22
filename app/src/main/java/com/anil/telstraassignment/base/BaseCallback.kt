package com.anil.telstraassignment.base

import android.support.v4.app.Fragment

interface BaseCallback {

    fun replaceFragment(fragment: Fragment, tag: String, isBackStack: Boolean)

}