package com.ecomartx.practise1.Programs

import com.ecomartx.practise1.printName

// Scope
//Solid Princele

//let , run. with, apply also
val name: String= "Naveen"



fun main(){
    val str= "Hello World"
    val outPut= manipulateStringData(str)
    print(outPut)
}
fun manipulateStringData(value: String): String {
    val firstValue= value.split(" ").first().uppercase()
    val secoundValue= value.split(" ").last()

    val fianalValue="$firstValue $secoundValue"


    return fianalValue.split(" ").joinToString(" - ").toCharArray().joinToString(" ")

    return value.replace(" "," - ").toCharArray().joinToString(" ").uppercase()

}