package com.ecomartx.practise1.parctise

inline fun doSomething(action: () -> Unit) {
    println("Before action")
    action()
    println("After action")
}

 fun main(){
    println("End")
}