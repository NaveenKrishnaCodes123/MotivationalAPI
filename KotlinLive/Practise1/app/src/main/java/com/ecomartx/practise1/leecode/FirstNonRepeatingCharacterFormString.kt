package com.ecomartx.practise1.leecode

fun main(){
    val input = "kotlinprogramming"
    val freqMap = mutableMapOf<Char, Int>()

    // Count frequency of each character
    for (ch in input) {
        freqMap[ch] = freqMap.getOrDefault(ch, 0) + 1
    }

    // Find first character with frequency 1
    var result: Char? = null
    for (ch in input) {
        if (freqMap[ch] == 1) {
            result = ch
            break
        }
    }

    println("First non-repeating character: $result")


}