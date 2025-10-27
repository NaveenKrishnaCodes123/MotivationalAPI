package com.ecomartx.practise1.leecode

fun main(){
    val list= mutableListOf(21,16,1,2,3,4,6,9,11)

    var first= list.min()
    var last= list.max()

    for(i in first..last){
        if (!list.contains(i)) {
            println(i) // Print missing value
        }
    }

}
