package com.ecomartx.practise1.parctise

 class Student private constructor(val name: String){
    companion object {
        fun create(name: String): User {
            return User(
                name,
                age = TODO(),
                mobileNumber = TODO()
            )
        }
}}

fun main(){
    //val user = User.create("Afroz")  // Access without instance
    //println(user.name) // Afroz
}