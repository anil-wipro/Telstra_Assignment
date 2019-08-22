package com.anil.telstraassignment.ui.aboutcanada

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anil.telstraassignment.R

class AboutCanadaFragment : Fragment() {

    private lateinit var activity: AboutCanadaActivity

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is AboutCanadaActivity)
            activity = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_aboutcanada,container,false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}