package com.ecomartx.practise1.leecode

fun main(){
    var unique=getUniqueData("To integrate Retrofit in to an Android project the following Project are typically added the")

    println(unique)
}

fun getUniqueData(input: String): String {
    val words = input.lowercase().split(" ")
    var data= mutableSetOf<String>()
    val duplicates = mutableSetOf<String>()
    for(i in words){
        if(!data.add(i)) {
            duplicates.add(i.lowercase())
        }
    }


    return duplicates.distinct().joinToString(" ")
}
