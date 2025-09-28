package com.ecomartx.practise1.Programs

import kotlin.collections.toCharArray

fun main() {
   val list=listOf(1,2,3,6,20,10)

   /* val min= (list.min())
    val max= (list.max())
    for (i in min..max){
        if(i !in list){
           // print(i)
        }
    }*/

    val str ="Hello World"
    val output= manipulateString(str)
    println("print the result as $output")
}
fun manipulateString(input: String): String {

   //  var  final= "${input.split(" ").first().uppercase()} ${input.split(" ").last().lowercase()}"

    return input.replace(" ", " - ").toCharArray().joinToString(" ").uppercase()
}

/*fun manipulateString(input: String): String {
    var first: String= input.split(" ").first().uppercase()
    var secoud: String= input.split(" ").last().lowercase()
    var  final= "$first $secoud"

    return final.split(" ").joinToString(" - ").toCharArray().joinToString(" ")
}*/

/*fun manipulateString(input: String): String {
    val parts = input.split(" ")
    val first = parts.first().uppercase()
    val second = parts.last().lowercase()
    val final = "$first $second"
    return final.replace(" ", " - ").toCharArray().joinToString(" ")
}*/
