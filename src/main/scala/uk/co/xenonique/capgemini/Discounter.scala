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
