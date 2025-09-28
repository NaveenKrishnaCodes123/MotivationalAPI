package com.ecomartx.practise1.Programs

class ValAndVar {

 val name: Int=8
 var name2:String="5"


}

lateinit var lateVal: String

val user by lazy {
    println("First One")
    "Naveen"
}


fun main(){
  println("Secound One")
    println(user)
    println(user)
}

//Secound One

//First One
//Naveen
