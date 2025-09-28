package com.ecomartx.motivationalapi

// Input1 = Viral Thakker
// Output1 = LARIV-REKKAHT

fun main() {
//    val input = "Viral Thakker"
//    val output = transform(input)
//    println(output) // Output: LARIV-REKKAHT

    val name ="My Name is Naveen Krishna Iam an Adroid Mobile Application Developer"

    for( i in name.split(" ")){
        val output= i.toString()
        println("${output.replace(".","")}                    Size   ${output.length}")
    }

}

fun transform(string: String): String {

    val firstNmae= string.split(" ").first().replace("Viral","LARIV")
    val secoundName= string.split(" ").last().replace("Thakker","REKKAHT")
    val final= "$firstNmae $secoundName"

    return final.replace(" "," - ").toCharArray().joinToString("").uppercase()
}
