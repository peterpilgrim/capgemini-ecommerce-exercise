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

import scala.collection.immutable.List
import scala.collection.mutable.ListBuffer

/**
  * The type CheckoutApplication
  *
  * @author Peter Pilgrim (peter)
  */


object CheckoutApplication {

  def main(args: Array[String]) {
    var ok = true
    println(
      """
        | Demo checkout shopping cart application
        |      by Peter Pilgrim, July 2017
        |
        | Written in Scala
        |
        | Commands:
        |      clear  -  clear the shopping cart
        |      exit   -  exit the application demo
        |      apple  -  add the product
        |      orange -  add the product
        |
      """.stripMargin)
    val itemList = ListBuffer[CartItem]()
    val discounters = List(new BuyThreeOrangesForTwoDiscounter(), new BuyTwoApplesGetOneFreeDiscounter)
    println(s"Your friendly discounts today are: ${discounters}\n")

    while (ok) {
      val shoppingCart = new ShoppingCart(itemList.toList, discounters)
      println(s"Cart :=  $itemList")
      printf("Checkout price £%.2f\n", shoppingCart.price())
      print("> ")
      System.out.flush()
      val ln = scala.io.StdIn.readLine()

      ok = ln != null
      if (ln != null ) {
        val cmd = ln.trim().toLowerCase()
        if ( "exit".equals(cmd)) {
          ok = false
        }
        else if ("clear".equals(cmd)) {
          itemList.clear()
        }
        else if ("apple".equals(cmd)) {
          itemList.append(Apple())
        }
        else if ("orange".equals(cmd)) {
          itemList.append(Orange())
        }
        else {
          println(s"Unrecognised shopping cart item: ${ln.trim()}")
        }
      }
    }
    println("Goodbye.")
  }
}
