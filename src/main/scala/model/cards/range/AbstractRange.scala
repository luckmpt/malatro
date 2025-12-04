package model.cards.range

import model.jokers.Jokers
import model.score.{IScore, Score}

/*
// abstract class of Range
// Values such as A, 2, 3, …, 10, J, Q, K. Which determine the value (chips)
// associated with the card and the order to which it corresponds.
*/
abstract class AbstractRange(
    private val name: String,
    private val order: Int,
    private val value: Int,
    private val typeOfRange: String) extends Range {

  // getName: -> String
  // return name of the Range
  def getName: String = name

  // getOrder: -> Int
  // return Order of the Range
  def getOrder: Int = order

  // getValue: -> Int
  // return Value of the Range
  def getValue: Int = value

  // getTypeOfRange: -> String
  // return TypeOfRange of the Range
  def getTypeOfRange: String = typeOfRange

  // IScore, Jokers -> IScore
  // The score of a rank is calculated, taking its rank
  // type into consideration, given a score and a joker.
  def applyScore(score: IScore, j: Jokers): IScore = score
}
