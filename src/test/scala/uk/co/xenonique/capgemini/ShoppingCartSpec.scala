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

  "A Shopping cart" should "calculate price of items in a list" in {
    new ShoppingCart( List() ).price() should === (0.0)
    new ShoppingCart( List( Orange()) ).price() should === (0.25)
    new ShoppingCart( List( Apple()) ).price() should === (0.60)
    new ShoppingCart( List( Orange(), Orange(), Apple()) ).price() should === (1.10)
    new ShoppingCart( List( Orange(), Apple(), Orange()) ).price() should === (1.10)
    new ShoppingCart( List( Apple(), Orange(), Orange(), Apple()) ).price() should === (1.70)
    new ShoppingCart( List( Apple(), Apple(), Orange(), Apple()) ).price() should === (2.05)      /* !!! */
  }

}