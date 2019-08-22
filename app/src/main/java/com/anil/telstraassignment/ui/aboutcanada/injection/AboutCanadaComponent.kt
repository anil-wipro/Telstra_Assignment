package com.anil.telstraassignment.ui.aboutcanada.injection

import com.anil.telstraassignment.di.AppComponent
import com.anil.telstraassignment.di.CustomScope
import com.anil.telstraassignment.ui.aboutcanada.AboutCanadaFragment
import dagger.Component

@CustomScope
@Component(dependencies = [AppComponent::class])
interface AboutCanadaComponent {

    fun inject(fragment: AboutCanadaFragment)

}