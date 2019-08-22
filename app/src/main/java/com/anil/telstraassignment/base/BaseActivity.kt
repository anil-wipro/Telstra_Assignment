package com.anil.telstraassignment.base

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.anil.telstraassignment.R

open class BaseActivity : AppCompatActivity(), BaseCallback {

    override fun replaceFragment(fragment: Fragment, tag: String, isBackStack: Boolean) {

        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.container, fragment, tag)

        if (isBackStack)
            fragmentTransaction.addToBackStack(fragment::class.java.simpleName)

        fragmentTransaction.commitAllowingStateLoss()
    }
}