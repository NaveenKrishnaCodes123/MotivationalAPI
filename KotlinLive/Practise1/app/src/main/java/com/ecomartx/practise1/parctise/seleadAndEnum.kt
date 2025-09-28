package com.ecomartx.practise1.parctise

fun main(){
    val color1= Colors.RED
    val color2= Colors.GREEN
}

enum class Colors{
    RED,BLUE,GREEN
}


sealed class Result()

data class Success(val data: String,val errorCode: Int): Result()
data class Failur(val data: String): Result()
object Loading: Result()

val result1= Success("Data Process Sucessfully",200)
val result2= Failur("Data Failur")
