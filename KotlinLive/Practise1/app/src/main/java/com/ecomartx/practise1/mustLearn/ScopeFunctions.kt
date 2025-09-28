package com.ecomartx.practise1.mustLearn


//let
//run
//with
//apply
//also


class Square(private val width: Int,
             private val hight: Int,
             private var color: String?=null,
             private var text: String?=null){

    fun fillcolor(newColor: String){
        this.color=newColor
        print("color")

    }
    fun fillText(newtext: String){
        this.text=newtext
        print("text")

    }

    override fun toString(): String {
        return "width : $width +length :$hight text : $text +color :$color"
    }

}
fun mainlet() {

    val square= Square(1,2).let {
        it.fillText("text")
        it.fillcolor("color")
        it
    }
println(square)
// for getting the result from it, we will use let---- lambda
  }

fun mainRun(){

    val square = Square(1,2).run {
         this.fillText("text run")
         this.fillText(" color run")
          this
        // for getting the result from this, we will use run---- lambda
    }
    println(square)
}

fun mainSquare(){
    val square= Square(1,2)
        with(square){
            square.fillText("Naveen")
            square.fillcolor("RED")
            square//return function
        }
   // with → same as run but called differently---- lambda
}

fun mainApply(){

    val square= Square(24,24).apply {
        fillText("My Text")
        fillcolor(" YELLOW")
    }
    println(square)


    // Apply no return Value ----context

}

fun mainAlso(){

    val square= Square(24,24).also {
        it.fillText("My Text")
        it.fillcolor(" YELLOW")
    }
    println(square)

    //Also is Same Like apply This but you should be initilize it  ---context

}

fun main(){

     for(num in 1..100){
         var isPrime= true
         for(i in 2 until num){
             if(num % i==0){
                 isPrime =false
                 break
             }

         }
         if(isPrime){
             println(num)
         }

     }


}


