package model.cards.range.odd

import model.cards.range.AbstractRange

/* 
Abstract class of odd ranks
 */
abstract class Odd(
    private val name: String,
    private val order: Int,
    private val value: Int,
) extends AbstractRange(name, order, value, "Odd"){
  
}
