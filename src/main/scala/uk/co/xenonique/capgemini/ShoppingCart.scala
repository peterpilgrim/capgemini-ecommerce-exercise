package uk.co.xenonique.capgemini

import scala.collection.mutable.ArrayBuffer

/**
  * The type ShoppingCart
  *
  * @author Peter Pilgrim (peter)
  */

class ShoppingCart(val items: List[CartItem], discounters: List[Discounter] = List()) {

  def price(): BigDecimal = {
    val fullPrice = items.map(x => x.price).sum

    val discountPrice = discounters.map(discounter => discounter.calculateDiscountPrice(items)).sum

    fullPrice - discountPrice
  }

}



object ShoppingCart {
  /**
    * Converts list of String matching {@link CartItem} types to Scala case classes
    *
    * @param cartItems list of cart item types
    */
  def convert(cartItems: List[String]): ShoppingCart = {
    val list = cartItems.map {
      name =>
        name.toLowerCase() match {
          case "orange" => Orange()
          case "apple" => Apple()
          case _ => throw new NoSuchElementException("Sorry I don't know this product!")
        }
    }
    new ShoppingCart(list)
  }

  /**
    * Converts list of String matching {@link CartItem} types to Scala case classes
    *
    * @param productText a text representation of a list of cart items
    */
  def convert(productText: String): ShoppingCart = {
    val list = productText.split("\\s+").toList
    convert(list)
  }
}

// End

