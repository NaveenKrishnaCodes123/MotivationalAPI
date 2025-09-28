package com.ecomartx.practise1.parctise

import okhttp3.internal.wait

data class Person(val name: String,val age:String)

fun main(){

    val person= Person("Naveen","25")
  //LET
    person.let {
        println(it.name)
    }
    // we can Initilize like this
    person.let {value ->
        println(value.name)

    }

    //RUN
    person.run {
        this.name
    }
    //with
   with(person) {
      println(person.age)
   }
  //APPLY
    person.apply {
       this.name
    }

//ALSO
    person.also {
        it.age
    }

}






