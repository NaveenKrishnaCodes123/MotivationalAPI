package com.ecomartx.practise1.mustLearn

fun String.getAllWords(): List<String>{
     return this.split(" ")
}

fun main(){

    val a: String="This Is Naveen"

    println(a.getAllWords())

    // you can add the new functions from exesting classes that you dont wone it makes esay and handle

}