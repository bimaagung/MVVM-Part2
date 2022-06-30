package com.otetcode.mvvmpart2

import android.app.Application
import com.otetcode.mvvmpart2.data.repositories.JsRepository
import com.otetcode.mvvmpart2.ui.movies.MovieDetailViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMapplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMapplication))
        bind() from singleton { JsRepository(instance()) }
        bind() from provider { MovieDetailViewModelFactory(instance())}
    }
}
