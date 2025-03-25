package com.example.kotlinprac.sample.features.auth

import com.example.kotlinprac.sample.core.Feature
import com.example.kotlinprac.sample.features.auth.credentials.Authenticator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun authFeature() = object : Feature {

    override fun name() = "auth"

    override fun diModule() = module {
        singleOf(::Authenticator)
    }
}
