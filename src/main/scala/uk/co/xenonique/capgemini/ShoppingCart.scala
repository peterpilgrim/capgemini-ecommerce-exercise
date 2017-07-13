/*******************************************************************************
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2017 by Peter Pilgrim, Milton Keynes, P.E.A.T UK LTD
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Creative Commons 3.0
 * Non Commercial Non Derivation Share-alike License
 * https://creativecommons.org/licenses/by-nc-nd/4.0/
 *
 * Developers:
 * Peter Pilgrim -- design, development and implementation
 *               -- Blog: http://www.xenonique.co.uk/blog/
 *               -- Twitter: @peter_pilgrim
 *
 * Contributors:
 *
 *******************************************************************************/
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

