package com.ecomartx.practise1.leecode




fun main() {
    val str = "abcdefg"
    val chars = str.toCharArray()

    for (i in 0 until chars.size - 1 step 2) {
        val temp = chars[i]
        chars[i] = chars[i + 1]
        chars[i + 1] = temp
    }

    println(String(chars)) // Output: "badcfeg"



//    val list = intArrayOf(1,2,3,4,5,6,7)
//    var target = 11
//    for(i in list.indices){
//        for(j in i+1 until list.size){
//            if(list[i]+list[j]==target){
//               println("$i, $j")
//            }
//        }
//    }

}