package com.anil.telstraassignment.ui.aboutcanada

import android.os.Bundle
import com.anil.telstraassignment.R
import com.anil.telstraassignment.base.BaseActivity
import kotlinx.android.synthetic.main.activity_aboutcanada.*
import kotlinx.android.synthetic.main.include_toolbar.view.*

class AboutCanadaActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aboutcanada)

        setSupportActionBar(toolbar_layout.toolbar_common)

        // set fragment to this activity
        replaceFragment(AboutCanadaFragment(), AboutCanadaFragment::class.java.simpleName, false)

    }
}
