package com.anil.telstraassignment.ui.aboutcanada

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anil.telstraassignment.MyApplication
import com.anil.telstraassignment.R
import com.anil.telstraassignment.ui.aboutcanada.injection.DaggerAboutCanadaComponent
import javax.inject.Inject

class AboutCanadaFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private lateinit var activity: AboutCanadaActivity
    private lateinit var viewModel: AboutCanadaViewModel

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is AboutCanadaActivity)
            activity = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_aboutcanada, container, false)
        DaggerAboutCanadaComponent.builder().appComponent(MyApplication.getAppComponent()).build().inject(this)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this, factory).get(AboutCanadaViewModel::class.java)

        viewModel.getAboutCanadaData()
    }

}