package com.ecomartx.practise1

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

fun main12(){
    val extensionfunction: String="Naveen"
    print(extensionfunction)
    extensionfunction.printName()
}

fun String.printName(){
    print("\n Hello $this")
}
//Extension function is accessing  the functions  which is out side of the class
// without inheriting or without modify the existing the class

fun main(){
    runBlocking(){

       var job1= launch {
           //delay(2000)
            coroutine1()
           println("coroutine1 :Thread: ${Thread.currentThread().name}")
        }
        //job1.cancel()
        val job2= launch(Dispatchers.IO) {
            println("coroutine2 : Thread: ${Thread.currentThread().name}")

           // withContext(Dispatchers.IO){
           //     println("coroutine2 :Thread: ${Thread.currentThread().name}")
                coroutine2()
           // }
        }
        job2.join()
        val job3= launch {
            println("coroutine3 :Thread: ${Thread.currentThread().name}")
            coroutine3()
        }
        job3.join()
        //job1.join()
    }

}
suspend fun coroutine1(){
    println("coroutine1()")
    delay(5000)
}
suspend fun coroutine2(){
    println("coroutine2()")
    delay(1000)
}
suspend fun coroutine3(){
    println("coroutine3()")
    delay(500)
}

