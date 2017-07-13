package uk.co.xenonique.capgemini

import org.junit.runner.RunWith
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.junit.JUnitRunner


import scala.collection.immutable.List

/**
  * The type ShoppingCartSpec
  *
  * @author Peter Pilgrim (peter)
  */
@RunWith(classOf[JUnitRunner])
class ShoppingCartSpec extends FlatSpec with Matchers{

  "A shopping cart" should "calculate price of items in a list" in {
    new ShoppingCart( List() ).price() should === (0.0)
    new ShoppingCart( List( Orange()) ).price() should === (0.25)
    new ShoppingCart( List( Apple()) ).price() should === (0.60)
    new ShoppingCart( List( Orange(), Orange(), Apple()) ).price() should === (1.10)
    new ShoppingCart( List( Orange(), Apple(), Orange()) ).price() should === (1.10)
    new ShoppingCart( List( Apple(), Orange(), Orange(), Apple()) ).price() should === (1.70)
    new ShoppingCart( List( Apple(), Apple(), Orange(), Apple()) ).price() should === (2.05)      /* !!! */
  }

  "Shopping cart" should "calculate price of items in a list" in {
    new ShoppingCart( List() ).price() should === (0.0)
    new ShoppingCart( List( Orange()) ).price() should === (0.25)
    new ShoppingCart( List( Apple()) ).price() should === (0.60)
    new ShoppingCart( List( Orange(), Orange(), Apple()) ).price() should === (1.10)
    new ShoppingCart( List( Orange(), Apple(), Orange()) ).price() should === (1.10)
    new ShoppingCart( List( Apple(), Orange(), Orange(), Apple()) ).price() should === (1.70)
    new ShoppingCart( List( Apple(), Apple(), Orange(), Apple()) ).price() should === (2.05)      /* !!! */
  }


  "A shopping cart" should "take a list of items as String text input" in {
    val cart1 = ShoppingCart.convert( List("Apple","orange","apple"))
    cart1.items should === (List(Apple(), Orange(), Apple()))

    val cart2 = ShoppingCart.convert( List("orange","APPLE","Orange"))
    cart2.items should === (List(Orange(), Apple(), Orange()))

    val cart3 = ShoppingCart.convert( List())
    cart3.items should === (List())

    val cart4 = ShoppingCart.convert( "Apple APPLE Orange apple")
    cart4.items should === (List(Apple(), Apple(), Orange(), Apple()))
  }

  "A shopping cart" should "barf with unrecognisable input" in {
    assertThrows[NoSuchElementException] {
      ShoppingCart.convert( List("Apple","DOG","CAT"))
    }
  }

  "A shopping cart" should "calculate price according to the example" in {
    ShoppingCart.convert( List( "Apple", "Apple", "Orange", "Apple") ).price() should === (2.05)      /* !!! */

    ShoppingCart.convert( "Apple Apple Orange Apple" ).price() should === (2.05)      /* !!! */
  }

}