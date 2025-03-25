package com.example.kotlinprac.sample.features.movies

import com.example.kotlinprac.sample.core.Feature
import com.example.kotlinprac.sample.features.movies.data.MoviesRepository
import com.example.kotlinprac.sample.features.movies.data.MoviesService
import com.example.kotlinprac.sample.features.movies.interactor.GetMovieDetails
import com.example.kotlinprac.sample.features.movies.interactor.GetMovies
import com.example.kotlinprac.sample.features.movies.interactor.PlayMovie
import com.example.kotlinprac.sample.features.movies.ui.MovieDetailsViewModel
import com.example.kotlinprac.sample.features.movies.ui.MoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun moviesFeature() = object : Feature {

    override fun name() = "movies"

    override fun diModule() = module {
        // Movies Feature
        factoryOf(::MoviesService)
        factory { MoviesRepository.Network(get(), get()) } bind MoviesRepository::class
        // Movies
        viewModelOf(::MoviesViewModel)
        factoryOf(::GetMovies)
        // Movie Details
        viewModelOf(::MovieDetailsViewModel)
        factoryOf(::GetMovieDetails)
        factoryOf(::PlayMovie)
    }
}
