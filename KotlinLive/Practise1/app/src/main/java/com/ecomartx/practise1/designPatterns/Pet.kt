package com.ecomartx.practise1.designPatterns

interface Pet {
    fun speak(): String
}

/*interface Pet {
    void speck(): String
}*/

class Dog:Pet{
    override fun speak()="Boww Boww"
}

class Cat: Pet{
    override fun speak()="Meow Meow"
}

object PetFactory{

    fun getPet(type : String):Pet{
        return when(type.lowercase()){
            "dog" -> Dog()
            "cat" -> Cat()
            else -> throw IllegalArgumentException("Unknown pet: $type")
        }
    }
}

fun  main() {
    // You ask the factory for a dog. You don't need to say "new Dog()"
    val myDog = PetFactory.getPet("dog")
    println(myDog.speak()) // Output: Woof!

    // You ask the factory for a cat.
    val myCat = PetFactory.getPet("cat")
    println(myCat.speak()) // Output: Meow!

    // You can easily add a new pet (e.g., a Duck) later by just modifying the factory.
    // The rest of your code doesn't need to change.
}