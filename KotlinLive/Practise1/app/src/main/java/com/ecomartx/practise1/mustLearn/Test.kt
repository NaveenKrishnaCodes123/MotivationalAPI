package com.ecomartx.practise1.mustLearn

fun main(){
    var largest= mutableListOf(9,1,2,10,3,4,5,6,7,8)

    var first= largest.min()
    for (i in largest){
        if(i>first&& i!=first){
          first=i
        }

    }
    println(first)

}