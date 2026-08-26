package com.practice.marketplace

/**
 * Abstract class representing an action in the marketplace.
 * It defines a method to execute the action on a cart, optionally with a product.
 */
abstract class MarketplaceAction {
    abstract fun execute(cart: Cart, product: Product? = null)
}

/**
 * Concrete action to add a product to the cart.
 * It overrides the execute method to perform the addition and print a confirmation message.
 *
 * if the product is null, no action is taken.
 *
 * @param cart The shopping cart to which the product will be added.
 * @param product The product to be added to the cart.
 */
class AddProductAction : MarketplaceAction() {
    override fun execute(cart: Cart, product: Product?) {
        if (product == null) return
        cart.addProduct(product)
        println("Added to cart: ${product.name}")
    }
}

/**
 * Concrete action to remove a product from the cart.
 * It overrides the execute method to perform the removal and print a confirmation message.
 * if the product is null, no action is taken.
 * @param cart The shopping cart from which the product will be removed.
 * @param product The product to be removed from the cart.
 */
class RemoveProductAction : MarketplaceAction() {
    override fun execute(cart: Cart, product: Product?) {
        if (product == null) return
        cart.removeProduct(product)
        println("Removed from cart: ${product.name}")
    }
}

/**
 * Concrete action to print the current contents of the cart.
 * The product parameter is unused for this action.
 *
 * @param cart The shopping cart to display.
 * @param product Not used by this action.
 */
class ViewCartAction : MarketplaceAction() {
    override fun execute(cart: Cart, product: Product?) {
        cart.printCart()
    }
}