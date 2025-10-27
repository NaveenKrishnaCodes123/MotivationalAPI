package com.ecomartx.practise1.leecode



fun main(){
    var input ="This is naveen"
    println(input.getData())
    println(getDataValue(input))

    println(input.split(" ").reversed().toString())
}

fun getDataValue(string: String): String {
  var data= ""
    for(i in string.length-1 downTo 0){
       data+=string[i]
    }
    return data
}

fun String.getData(): String{
    var data= ""
    for( i in this.length-1 downTo 0){
        data+=this[i]
    }

    return data
}

