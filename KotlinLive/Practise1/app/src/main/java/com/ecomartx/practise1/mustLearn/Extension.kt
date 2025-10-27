package com.ecomartx.practise1.mustLearn

fun String.getAllWords(): List<String>{
     return this.split(" ")
}

fun main2(){

    val a: String="This Is Naveen"

    println(a.getAllWords())

    // you can add the new functions from exesting classes that you dont wone it makes esay and handle

}

fun String.calculate(value :String):String{
    return value.split(" ").toString()
}

fun main(){
    var name="Naveen"
    println(name.calculate(""))
}