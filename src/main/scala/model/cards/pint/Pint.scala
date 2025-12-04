package model.cards.pint

import model.applyScore.ApplyScore

/*
Interface Pint of cards, are 4 class: 
hearts, diamonds, clubs and spades
*/
trait Pint extends ApplyScore{

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean

  // genName: -> String
  // return name of the card
  def getName: String
  
}
