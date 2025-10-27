package com.ecomartx.practise1.AccessModifiers

internal class InternalClass {
    internal val data = "Module data"
}

fun main() {
    val obj = InternalClass()
    println(obj.data) // ✅ accessible in same module
}

//🔹 Quick Summary
//Modifier	Class	Subclass	Same Module 	Everywhere
//public	✅	     ✅       	✅	              ✅
//internal	✅	     ✅       	❌	              ❌
//protected	✅	     ✅         ❌                ❌
//private	✅	     ❌      	❌                ❌