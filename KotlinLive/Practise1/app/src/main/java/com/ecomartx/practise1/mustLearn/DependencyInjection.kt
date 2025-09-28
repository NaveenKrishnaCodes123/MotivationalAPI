package com.ecomartx.practise1.mustLearn

//class Car{
//
////    private val engine=Engine()
////
////        fun start(){
////            engine.s
////        }
//
//}

//fun main(args: Array){
//    val car=Car()
//    car.start()
//}

class Engine {
    fun start() = "Engine Started"
}

class Car(private val engine: Engine) { // ✅ Engine injected from outside
    fun drive() {
        println(engine.start())
    }
}

fun main() {
    val engine = Engine()
    val car = Car(engine) // Inject engine here
    car.drive()
}