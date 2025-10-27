package com.ecomartx.practise1.leecode

fun maxArea(height: DoubleArray): Double {
    var left = 0
    var right = height.size - 1
    var maxArea = 0.0

    while (left < right) {
        val minHeight = minOf(height[left], height[right])
        val width = right - left
        val currentArea = minHeight * width

        maxArea = maxOf(maxArea, currentArea)

        // Move the pointer with smaller height
        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }

    return maxArea
}

fun main() {
    val heights = doubleArrayOf(9.0, 8.0, 1.0, 4.0, 4.0, 3.0, 4.0, 2.0, 1.0)
    val result = maxArea(heights)
    println("Max area: $result") // Output: Max area: 48.0
}