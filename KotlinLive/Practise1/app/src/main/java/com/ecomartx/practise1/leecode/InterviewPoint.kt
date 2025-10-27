package com.ecomartx.practise1.leecode

class InterviewPoint {
}

//Reverse a String
fun main1() {
    val reverse = "Naveen"
    println(reverse.reversed())
}

//Check Palindrome

fun main2() {
    val palindrome = "madam"
    if (palindrome == palindrome.reversed()) {
        println(true)
    } else {
        println(false)
    }
}

//Two Sum Problem

fun main21() {
    val nums = intArrayOf(3, 4, 5, 6)
    val target = 8
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] == target) {
                println("$i, $j")
            }
        }

    }
}

fun main20() {
    val nums = intArrayOf(3, 4, 5, 6)
    val target = 7
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] == target) {
                println("$i,$j")
            }
        }
    }
}


//Anagram Check

fun main4() {
    var s = ("racecar")
    var t = ("carrace")
    if (s.length == t.length && s.toCharArray().sorted() == t.toCharArray().sorted()) {
        println(true)
    } else {
        println(false)
    }
}

//Find Second Largest Element
val value = intArrayOf(22, 44, 66, 87, 10, 5, 20, 8)
fun main5() {
    println(value.distinct().sorted().reversed().get(1))

    var first = value.min()
    var secound = value.min()
    for (i in value) {
         if (i > secound && i != first) {
            secound = i
        }
    }
    println(secound)

}

//Longest Substring Without Repeating Characters
fun main9() {
    var longest = 0
    var current = ""

    for (ch in "abcabcabc") {
        if (ch in current) {
            current = current.substringAfter(ch) + ch
        } else {
            current += ch
        }
        longest = maxOf(longest, current.length)
    }
    println(current)
}

fun main8() {

    val result = getData("a1b2c3")

}

fun getData(string: String) {

    var result = string.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)".toRegex()).chunked(2)
        .joinToString("") { (char, num) ->
            char.repeat(num.toIntOrNull() ?: 1)
        }
    println(result)
}

fun main12() {
    var missingLetter = mutableListOf(1, 2, 4, 5, 6, 9)
    /* for(i in missingLetter.i){

     }*/

}

fun add(a: Int, b: Int): Int {
    return a * b
}


fun main44() {
    val values = "abcdefghijklmnop"
    val sb = StringBuilder()
    for (i in values.indices) {
        sb.append(values[i])
        if ((i + 1) % 5 == 0 && i != values.lastIndex) {
            sb.append(' ')
        }
    }

    println(sb.toString())


}

//Reverse
fun main99() {

    val reverser = "MY name is naveen"
    for (i in reverser.length - 1 downTo 0) {
        print(reverser[i])
    }
    // println(data)

}


//print secound largest Number

fun main14() {
    val large = mutableListOf(1, 63, 2, 3, 4, 5, 44, 6, 7, 8)
    var first = large.min()
    var secound = large.min()
    for (i in large) {
        if (i > first) {
            secound = first
            first = i
        } else if (i > secound && i != first) {
            secound = i
        }
    }
    println(secound)
}

// missing numbers in array

fun main13() {
    val large = mutableListOf(1, 63, 2, 3, 4, 5, 44, 6, 7, 8)
    var min = large.min()
    var max = large.max()

    for (i in min..max) {
        if (!large.contains(i)) {
            println(i)
        }
    }

    println("")
}

fun String.calculateData(): String {
    return "$this Krishna"
}

fun main10() {

    var name = "Naveen"
    println(name.calculateData().toString())
}

fun main() {
    val input = "abcdefghijkl123456789"
    var digits = ""
    var letters = ""

    for (ch in input) {
        if (ch in '0'..'9') {
            digits += ch
        } else {
            letters += ch
        }
    }
    println("$digits    $letters")

   var result=""
    var i=0
    var j=0
    var group=1

    while (i<digits.length&&j<letters.length){

        var k=0
        while(k<group&& i<digits.length){
            result+=digits[i++]
            k++
        }

         k=0
        while(k<group&& j<letters.length){
            result+=letters[j++]
            k++
        }
        group++


    }
    println(result)

}


