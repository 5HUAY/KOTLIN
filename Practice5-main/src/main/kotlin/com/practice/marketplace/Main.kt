package com.practice.marketplace

fun main() {
    val products = listOf(
        Product(1, "Book", 9.99),
        Product(2, "Laptop", 799.0),
        Product(3, "Phone", 499.0)
    )

    val cart = Cart()
    val addAction = AddProductAction()
    val removeAction = RemoveProductAction()
    val viewAction = ViewCartAction()

    while (true) {
        println("\n=== Marketplace ===")
        println("+----+-----------+--------+")
        println("| ID | Product   | Price  |")
        println("+----+-----------+--------+")
        for (p in products) {
            println("| %-2d | %-9s | $%-5.2f |".format(p.id, p.name, p.price))
        }
        println("+----+-----------+--------+")
        println("Choose action: add <id>, remove <id>, view, exit")

        val input = readLine()?.trim() ?: continue
        if (input == "exit") break

        when {
            input.startsWith("add") -> {
                val id = input.split(" ").getOrNull(1)?.toIntOrNull()
                val product = products.find { it.id == id }
                if (product != null) addAction.execute(cart, product) else println("Product not found.")
            }

            input.startsWith("remove") -> {
                val id = input.split(" ").getOrNull(1)?.toIntOrNull()
                val product = products.find { it.id == id }
                if (product != null) removeAction.execute(cart, product) else println("Product not found.")
            }

            input == "view" -> {
                viewAction.execute(cart)
            }
            else -> println("Invalid command.")
        }
    }
}