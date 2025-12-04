package model.cards.pint

import model.jokers.Jokers
import model.score.{IScore, Score}

/*
Pint of cards, are 4 class:
hearts, diamonds, clubs and spades
*/
abstract class AbstractPint(private val name: String) extends Pint{

  // genName: -> String
  // return name of the card
  def getName: String = name

  // IScore, Jokers -> IScore
  // The score of a pint is calculated, given a score and a joker.
  def applyScore(score: IScore, j: Jokers): IScore = score
}
