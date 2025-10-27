package com.ecomartx.test

fun main(){
    var secoundLarge= mutableListOf(1,200,3,4,5,6,7,9,23,45)

    //Missing letters in array
      var data= mutableSetOf<Int>()
     for( i in secoundLarge.min()..secoundLarge.max()){
         if(!secoundLarge.contains(i)){
             data.add(i)
         }
     }
    //println(data)


    //a1b2c3

    var value ="a1b2c3"

    var result= value.split("(?<=\\D)(?=\\d)|(?=\\D)(?<=\\d)".toRegex()).chunked(2).joinToString(""){
        (char,num)-> char.repeat(num.toIntOrNull()?:1)
    }
    println(result)





   /* var first= secoundLarge.min()
    var secound= secoundLarge.min()

    for(i in secoundLarge){
        if(i>first){
            secound=first
            first=i
        }else if(i> secound&& i!=first){
            secound=i
        }
    }
    println("secound largest Number $secound")*/
}