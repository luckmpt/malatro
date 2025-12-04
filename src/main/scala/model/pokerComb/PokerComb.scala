package model.pokerComb

import model.applyScore.ApplyScore
import model.cards.ICards
import model.score.IScore

/* 
trait: PokerComb 
There are multiple valid poker combinations. 
Each combination has a specific condition that
must be met to be valid and a base score
 */
trait PokerComb extends ApplyScore{
  
  // getScore: -> IScore
  // return score of the poker combination
  def getScore: IScore

  // getName: -> String
  // return name of the poker combination
  def getName: String

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean
  
  // verifyCards: List[ICards] -> Boolean
  // check if a list of cards meets (or does not meet) 
  // the combination condition
  def verifyCards(listCards: List[ICards]): Boolean
}
