/*******************************************************************************
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
 *               -- Blog: http://www.xenonique.co.uk/blog/
 *               -- Twitter: @peter_pilgrim
 *
 * Contributors:
 *
 *******************************************************************************/
package uk.co.xenonique.agileit

/**
  * The type CartItem
  *
  * @author Peter Pilgrim (peter)
  */

sealed trait CartItem {
  val name: String;
  val price: BigDecimal
}

final case class Orange( override val name: String = "Orange",
                         override val price: BigDecimal = 0.25) extends CartItem

final case class Apple( override val name: String = "Apple",
                        override val price: BigDecimal = 0.60) extends CartItem
