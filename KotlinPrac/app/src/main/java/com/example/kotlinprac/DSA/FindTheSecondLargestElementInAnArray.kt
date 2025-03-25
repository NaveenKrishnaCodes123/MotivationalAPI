package com.example.kotlinprac.DSA

fun main(){
    val arrayData= intArrayOf(1111,23,45,64,76,37,101,99,56,46)
   // println(arrayData.max())
    //println(arrayData.min())

    var firstlargestElement= arrayData.min()
    var secoundlargestElement= arrayData.min()
    for (i in arrayData){
         if (i>firstlargestElement){
             secoundlargestElement=firstlargestElement
             firstlargestElement=i
         }else if(i > secoundlargestElement&& i!=firstlargestElement){
             secoundlargestElement=i
         }
    }
    if (secoundlargestElement != Int.MIN_VALUE) {
        println("The second largest element is: $secoundlargestElement")
    } else {
        println("There is no second largest element.")
    }
}