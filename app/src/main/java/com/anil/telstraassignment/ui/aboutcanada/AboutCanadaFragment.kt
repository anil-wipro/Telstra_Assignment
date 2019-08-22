package com.anil.telstraassignment.ui.aboutcanada

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.anil.telstraassignment.MyApplication
import com.anil.telstraassignment.R
import com.anil.telstraassignment.data.ItemAboutCanada
import com.anil.telstraassignment.ui.aboutcanada.injection.DaggerAboutCanadaComponent
import kotlinx.android.synthetic.main.fragment_aboutcanada.*
import javax.inject.Inject

class AboutCanadaFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private lateinit var activity: AboutCanadaActivity
    private lateinit var viewModel: AboutCanadaViewModel
    private lateinit var aboutCanadaAdapter: AboutCanadaAdapter

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

        setUpRecyclerView()

        viewModel = ViewModelProviders.of(this, factory).get(AboutCanadaViewModel::class.java)

        observeViewModel()

    }

    private fun setUpRecyclerView() {

        // set  adapter to recycler view
        val dividerItemDecoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(activity, R.drawable.divider_recyclerview)!!)
        rv_about_canada.addItemDecoration(dividerItemDecoration)
        rv_about_canada.layoutManager = LinearLayoutManager(activity)
        aboutCanadaAdapter = AboutCanadaAdapter(activity)
        rv_about_canada.adapter = aboutCanadaAdapter

    }

    private fun observeViewModel() {
        
        // observe result
        viewModel.getAboutCanadaData()?.observe(this, Observer { result -> showDataToUI(result) })

        // observe loading state 
        viewModel.getLoadingState().observe(this, Observer { loadingState -> handleLoadingState(loadingState) })
    }

    private fun handleLoadingState(loadingState: Int?) {

        when (loadingState) {
            View.GONE -> {
                iv_loader.visibility = View.GONE
                iv_loader.clearAnimation()
            }
            View.VISIBLE -> {
                iv_loader.visibility = View.VISIBLE
                val loaderAnim = AnimationUtils.loadAnimation(activity, R.anim.loader)
                iv_loader.startAnimation(loaderAnim)
            }
        }
    }

    private fun showDataToUI(itemAboutCanada: ItemAboutCanada?) {

        (activity).supportActionBar?.title = itemAboutCanada?.title

        itemAboutCanada?.let { aboutCanadaAdapter.setData(itemAboutCanada.rows) }
    }

}