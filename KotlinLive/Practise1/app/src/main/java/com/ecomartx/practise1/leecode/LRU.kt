package com.ecomartx.practise1.leecode

class LRUCache<K, V>( val capacity: Int)
    : LinkedHashMap<K, V>(capacity, 0.75f, true) {

    override fun removeEldestEntry(eldest: MutableMap.MutableEntry<K, V>?): Boolean {
        return size > capacity
    }
}

fun main() {
    val cache = LRUCache<Int, String>(2)
    cache[1] = "A"
    cache[2] = "B"
    println(cache) // {1=A, 2=B}

    cache[3] = "C" // removes 1 (least recently used)
    println(cache) // {2=B, 3=C}

    cache[2]       // Access 2 -> makes it most recently used
    cache[4] = "D" // removes 3
    println(cache) // {2=B, 4=D}
}

class LRUCachee<K,V>(val capacity: Int): LinkedHashMap<K,V>(capacity,0.75f,true){

    override fun removeEldestEntry(eldest: Map.Entry<K?, V?>?): Boolean {
        return size>capacity
    }
}