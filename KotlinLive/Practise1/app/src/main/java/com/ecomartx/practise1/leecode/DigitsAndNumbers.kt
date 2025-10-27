package com.ecomartx.practise1.leecode

fun main() {
    val input = "abcdefghi123456789"
    var letters = ""
    var digits = ""

    for (ch in input) {
        if (ch in '0'..'9') {
            digits += ch
        } else {
            letters += ch
        }
    }

    var result=""
    var i=0
    var j=0
    var group=1

    while (i<letters.length&&j<digits.length){

        var k=0

        while(k<group&&i<letters.length){
            result+=letters[i++]
            k++
        }
        k=0
        while(k<group&&j<digits.length){
            result+=digits[j++]
            k++
        }
        group++
    }

    println(result)



    // Add remaining characters (if any)
    while (i < letters.length) result += letters[i++]
    while (j < digits.length) result += digits[j++]

    println(result) // ✅ Output: a1bc23def456
}
