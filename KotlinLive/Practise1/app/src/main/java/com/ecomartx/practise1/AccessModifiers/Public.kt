package com.ecomartx.practise1.AccessModifiers

class Public {

    public var name: String="Naveen Krishna"
}

fun main(){

    var obj= Public()

    println(obj.name)
}

//🔹 Quick Summary
//Modifier	Class	Subclass	Same Module 	Everywhere
//public	✅	     ✅       	✅	              ✅
//internal	✅	     ✅         ✅		          ❌
//protected	✅	     ✅         ❌                ❌
//private	✅	     ❌      	❌                ❌