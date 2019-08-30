package com.anil.telstraassignment.ui.aboutcanada

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor(private val repository: AboutCanadaRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(AboutCanadaViewModel::class.java)) {
            return AboutCanadaViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}