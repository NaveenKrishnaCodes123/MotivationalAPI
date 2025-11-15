package com.ecomartx.practise1.Thread

fun getUserInfo(userId:String):User{
    Thread.sleep(3000)
    return User(userId,"Naveen")
}

fun main(){
    println(getUserInfo("1"))
}