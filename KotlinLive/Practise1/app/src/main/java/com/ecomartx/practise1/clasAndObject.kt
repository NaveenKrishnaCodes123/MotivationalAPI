package com.ecomartx.practise1

class Person(val name: String) {
    fun greet() = "hello my name is $name"
}

fun main() {
    val p = Person("Naveen") // object of class
    println(p.greet())         // hello my name is Naveen
}

//object
object Logger {
    fun log(msg: String) = println("Log: $msg")
}
fun main1() {
    Logger.log("App started")   // directly accessible
}


class Utils {
    companion object {
        fun printMessage() = println("Hello from Companion")
    }
}
fun main2() {
    Utils.printMessage()  // called without creating Utils object
}