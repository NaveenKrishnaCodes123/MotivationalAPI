package com.ecomartx.practise1.AccessModifiers

class Private {
    private var name: String="Naveen"

    fun showName() = name
}
fun main(){
    val obj = Private()
    //println(obj.name())  // ❌ Error: 'secret' is private
    println(obj.showName())
}

//🔹 Quick Summary
//Modifier	Class	Subclass	Same Module 	Everywhere
//public	✅	     ✅       	✅	              ✅
//internal	✅	     ✅       	❌	              ❌
//protected	✅	     ✅         ❌                ❌
//private	✅	     ❌      	❌                ❌