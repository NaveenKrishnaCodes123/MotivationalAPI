package com.ecomartx.practise1

class lateAndLazyit{

    private lateinit var name: String

    fun NameValue(value : String){
        name=value
        print("Tell me your Name : $name")
    }
}

fun mainjj(){
    val value= lateAndLazyit()
    value.NameValue("Naveen")

}

class LazyData(){

    init {
        print("Naveen is good")
    }
}
class MyApp(){

    val dataclas: LazyData by lazy {
        println("Initializing now...")
        LazyData()
    }

}


/*
fun main(){
    if (condition) {

    }
}*/
