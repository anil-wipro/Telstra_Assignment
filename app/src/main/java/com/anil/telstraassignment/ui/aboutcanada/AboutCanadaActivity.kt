package com.anil.telstraassignment.ui.aboutcanada

import android.os.Bundle
import com.anil.telstraassignment.R
import com.anil.telstraassignment.base.BaseActivity

class AboutCanadaActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aboutcanada)

        // set fragment to this activity
        replaceFragment(AboutCanadaFragment(), AboutCanadaFragment::class.java.simpleName, false)

    }
}
