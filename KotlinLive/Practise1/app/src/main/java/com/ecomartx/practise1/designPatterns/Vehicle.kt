package com.ecomartx.practise1.designPatterns

interface Transport {
    fun Vehicle()
}

class Truck:Transport{
    override fun Vehicle() {
        println("Transport by Road")
        }

}

class Ship: Transport{
    override fun Vehicle() {
        println("Transport via sea")
    }

}

abstract class Logistics(){
    abstract fun createTransport(): Transport
}

