package uk.co.xenonique.capgemini

/**
  * The type Discounter
  *
  * @author Peter Pilgrim (peter)
  */

trait Discounter {
  def calculateDiscountPrice(items: List[CartItem]): BigDecimal
}

// Buy one, get one free on Apples

class BuyTwoApplesGetOneFreeDiscounter extends Discounter {
  def calculateDiscountPrice(items: List[CartItem]): BigDecimal = {
    val n = items.filter(x => x.equals(Apple())).size
    if (n >= 2)
      n / 2 * Apple().price
    else
      0.0
  }
}


// 3 for the price of 2 on Oranges

class BuyThreeOrangesForTwoDiscounter extends Discounter {
  def calculateDiscountPrice(items: List[CartItem]): BigDecimal = {
    val n = items.filter(x => x.equals(Orange())).size
    if (n >= 3)
      n / 3 * Orange().price
    else
      0.0
  }
}
