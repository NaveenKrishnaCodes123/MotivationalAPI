package com.example.kotlinprac.sample.features.login

import com.example.kotlinprac.sample.core.Feature
import org.koin.dsl.module

fun loginFeature() = object : Feature {

    override fun name() = "login"

    override fun diModule() = module {}
}
