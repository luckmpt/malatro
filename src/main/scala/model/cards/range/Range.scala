package model.cards.range

import model.applyScore.ApplyScore

/*
Interface of Range
Value such as A, 2, 3, …, 10, J, Q, K. Which determine the value (chips)
associated with the card and the order to which it corresponds.
 */
trait Range extends ApplyScore {
  
  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean
  
  // getName: -> String
  // return name of the Range
  def getName: String

  // getOrder: -> Int
  // return Order of the Range
  def getOrder: Int

  // getValue: -> Int
  // return Value of the Range
  def getValue: Int

  // getTypeOfRange: -> String
  // return TypeOfRange of the Range
  def getTypeOfRange: String
  
}
