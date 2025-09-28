package com.ecomartx.practise1.mustLearn

//enum class = a special class that represents a fixed set of constants.


enum class Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
enum class Color(val code: String) {
    RED("#FF0000"),
    GREEN("#00FF00"),
    BLUE("#0000FF")
}

//println(Color.RED.code) // #FF0000