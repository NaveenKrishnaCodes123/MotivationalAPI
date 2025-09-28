package com.ecomartx.practise1.Programs

// a2b3c4
// aabbbcccc

fun main(){
    val name= mutableListOf<String>("MY NAME IS NAVEEN")
    val data: String="a1b3c4"

    println(decodeString(data))

     println(decodeStringjuj(name.toString()))
}

fun decodeStringjuj(string: String) {

    string.replace("MY","              ")

}

fun decodeString(input: String): String {

//    return input.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)".toRegex())
//        .chunked(2)
//        .joinToString("") { (char, num) ->
//            char.repeat(num.toIntOrNull() ?: 1)
//        }

  return input.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)".toRegex()).chunked(2).joinToString()
  {(char,num)->
      char.repeat((num.toIntOrNull()?:1))

  }
}