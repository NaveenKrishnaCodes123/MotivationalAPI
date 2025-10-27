package com.ecomartx.practise1.AccessModifiers

open class Protected {
    protected val name = "Parent"
}

class Child : Protected() {
    fun printName() = println(name) // ✅ accessible in subclass
}

fun main() {
    val c = Child()
    // println(c.name) // ❌ Error: protected not visible outside class/subclass
    c.printName() // ✅ works
}

//🔹 Quick Summary
//Modifier	Class	Subclass	Same Module 	Everywhere
//public	✅	     ✅       	✅	              ✅
//internal	✅	     ✅       	❌	              ❌
//protected	✅	     ✅         ❌                ❌
//private	✅	     ❌      	❌                ❌