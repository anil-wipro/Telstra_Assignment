package com.anil.telstraassignment.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.appcompat.app.AppCompatActivity
import com.anil.telstraassignment.R

open class BaseActivity : AppCompatActivity(), BaseCallback {

    override fun replaceFragment(fragment: Fragment, tag: String, isBackStack: Boolean) {

        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.container, fragment, tag)

        if (isBackStack)
            fragmentTransaction.addToBackStack(fragment::class.java.simpleName)

        fragmentTransaction.commit()
    }
}