package com.ecomartx.practise1.leecode

fun main() {

    //SUM
    val sum = intArrayOf(1, 9, 6, 4, 8, 3, 2, 4)
    var total = 0
    for (i in sum) {
        total += i
    }
    println(total)


    //Check if an array is sorted

    println(sum.sorted().toString())

    val arr = intArrayOf(1, 2, 3, 2, 4, 2, 5)
    val target = 7
    var count = 0

    for (i in arr) {
        for (j in i + 1 until arr.size) {
            if (arr[i] + arr[j] == target) {
                println("Pair found: arr[$i]=${arr[i]} + arr[$j]=${arr[j]} = $target")
            }
        }
    }

    //Merge Two sorts
    val arr1 = intArrayOf(1, 3, 5, 7)
    val arr2 = intArrayOf(2, 4, 6, 8)
    var result = (arr1 + arr2).distinct().sorted()
    println(result)

    //misssing Numbers in array
    for (i in arr1.min()..arr1.max()) {
        if (!arr1.contains(i)) {
            println(i)
        }
    }

    //Move all zeros at end

    val zeros = intArrayOf(0, 1, 0, 3, 12)
    val zeros1 = mutableListOf<Int>()
    val zeros2=mutableListOf<Int>()

    for(i in zeros){
        if(i==0){
            zeros2.add(i)
        }else{
            zeros1.add(i)
        }
    }
    println(zeros1+zeros2)
}