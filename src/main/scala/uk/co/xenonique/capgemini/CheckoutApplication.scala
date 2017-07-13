package uk.co.xenonique.capgemini

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

    while (ok) {
      val shoppingCart = new ShoppingCart(itemList.toList)
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
