package com.ecomartx.practise1

fun main(){
    val extensionfunction: String="Naveen"
    print(extensionfunction)
    extensionfunction.printName()
}

fun String.printName(){
    print("\n Hello $this")
}
//Extension function is accessing  the functions  which is out side of the class
// without inheriting or without modify the existing the class

