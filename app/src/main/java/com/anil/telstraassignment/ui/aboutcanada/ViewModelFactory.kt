package com.anil.telstraassignment.ui.aboutcanada

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val repository: AboutCanadaRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AboutCanadaViewModel(repository) as T
    }
}