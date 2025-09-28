package com.ecomartx.practise1.mustLearn

open class Naveen(){
    fun main(){
        println("Test")
    }
}

class Student : Naveen(){
    fun study() {
        println("Studying...")
    }
}

fun main(){
    println(Student())
}


//lateinit var name: String
//
//val test : String by lazy{
//     println("START")
//    "Naveen"
//}
//fun main(){
//
//    println("END")
//    println(test)
//    println(test)
//}