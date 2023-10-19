package com.guilhermereisdev.tvguide.presentation.di.tvshow

import com.guilhermereisdev.tvguide.presentation.tvshow.TVShowActivity
import dagger.Subcomponent

@TVShowScope
@Subcomponent(modules = [TVShowModule::class])
interface TVShowSubcomponent {
    fun inject(tvShowActivity: TVShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TVShowSubcomponent
    }
}
