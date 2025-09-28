package com.ecomartx.practise1.leecode

//Group Anagrams

fun main(){
    val words = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")

    val group= words.groupBy { it.toCharArray().sorted().joinToString("") }.values.toList()

    println(group)
}