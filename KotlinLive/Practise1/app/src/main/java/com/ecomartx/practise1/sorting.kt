package com.ecomartx.practise1


fun main() {

    data class Transaction(
        val category: String,
        val amount: Double
    )

    val transactions = listOf(
        Transaction("Food", 50.0),
        Transaction("Travel", 200.0),
        Transaction("Shopping", 100.0),
        Transaction("Food", 30.0),
        Transaction("Travel", 150.0),
        Transaction("Bills", 80.0)
    )

    val sortedTransactions = transactions
        .groupBy { it.category } // Group by category
        .mapValues { entry -> entry.value.sumOf { it.amount } } // Sum each group
        .toList() // Convert map to list of pairs
        .sortedByDescending { (_, total) -> total } // Sort by total amount descending


    println("=== Transaction Totals (Descending) ===")

    sortedTransactions.forEach { (category, total) ->
        println("$category → $total")
    }
}
