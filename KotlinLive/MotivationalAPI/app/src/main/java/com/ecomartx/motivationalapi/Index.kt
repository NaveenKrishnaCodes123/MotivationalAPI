package com.ecomartx.motivationalapi

//arr = [2, 3, 4, 7, 11, 15]

val height = listOf(1,8,6,2,5,4,8,3,7)

val width = listOf(0,1,2,3,4,5,6,7,8)



fun main() {
    var maxArea = 0

    for (i in height.indices) {
        for (j in i + 1 until height.size) {
            val h = minOf(height[i], height[j])
            val w = j - i
            val area = h * w
            if (area > maxArea) {
                maxArea = area
            }
        }
    }
    println("Maximum area = $maxArea")
}
