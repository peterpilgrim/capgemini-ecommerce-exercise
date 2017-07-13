/** *****************************************************************************
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
  *
  * Copyright (c) 2016 by Peter Pilgrim, Milton Keynes, P.E.A.T UK LTD
  *
  * All rights reserved. This program and the accompanying materials
  * are made available under the terms of the Creative Commons 3.0
  * Non Commercial Non Derivation Share-alike License
  * https://creativecommons.org/licenses/by-nc-nd/4.0/
  *
  * Developers:
  * Peter Pilgrim -- design, development and implementation
  * -- Blog: http://www.xenonique.co.uk/blog/
  * -- Twitter: @peter_pilgrim
  *
  * Contributors:
  *
  * ******************************************************************************/
package uk.co.xenonique.agileit

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
  // Convert strings to Scala case classes
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

}
