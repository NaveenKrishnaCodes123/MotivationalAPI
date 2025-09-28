package com.ecomartx.practise1.designPatterns

abstract class Pizza {
    abstract fun prepare()
}

class Margherita : Pizza() {
    override fun prepare() {
        println("Print Margherita pizaa")
    }
}

class Salami : Pizza() {
    override fun prepare() {
        println("Print Salami pizaa")
    }
}

class Veggie : Pizza() {
    override fun prepare() {
        println("Print Veggie pizaa")
    }
}

abstract class PizzaFactory {
    abstract fun createPizza(type: String): Pizza
}

class ConcretePizzaFactory : PizzaFactory() {
    override fun createPizza(type: String): Pizza = when (type) {
        "Margherita" -> Margherita()
        "Salami" -> Salami()
        "Veggie" -> Veggie()
        else -> throw IllegalArgumentException("Unknown pizza type")
    }
}


