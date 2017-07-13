package uk.co.xenonique.capgemini

/**
  * The type CartIItem
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
