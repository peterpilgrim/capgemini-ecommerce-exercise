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

import org.junit.runner.RunWith
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.junit.JUnitRunner

import scala.collection.immutable.List


/**
  * The {@link DiscounterSpec} validates the operation and behaviour of @{link DiscounterSpec}
  *
  * @author Peter Pilgrim (peter)
  */
@RunWith(classOf[JUnitRunner])
class DiscounterSpec extends FlatSpec with Matchers {

  "A discounter" should "buy one get one free on Apples" in {
    new BuyTwoApplesGetOneFreeDiscounter().calculateDiscountPrice( List(Apple(),Apple())) should === (Apple().price)
  }

  "A discounter" should "discount for 3 for the price of 2 on Oranges" in {
    new BuyThreeOrangesForTwoDiscounter().calculateDiscountPrice( List(Orange(),Orange(),Orange())) should === (Orange().price )
  }

}


