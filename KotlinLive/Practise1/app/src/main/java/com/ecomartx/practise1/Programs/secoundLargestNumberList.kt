package com.ecomartx.practise1.Programs



var value = listOf(1,2,20,4,5,6,7,8)
fun main1(){

    var largestNumber= value.min()
    var smallNumber= value.min()

    var secoundLargestNumber=value.distinct().sortedDescending()
    println(secoundLargestNumber.get(1))
}

//prin a1b2c3

fun main(){

    var data= TaskValues("a2b3c4")
    println(data.toString())
}

fun TaskValues(value: String): String{

    return value.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)".toRegex()).chunked(2).joinToString(){
        (char,num)->
        char.repeat(num.toIntOrNull()?:1)
    }
}






