package model.jokers

import model.pokerComb.Straight
import model.score.IScore

/*
 interface Jokers 
 are special cards that are not played as part of the poker hand,
 but remain active, modifying the scoring rules.
 */
trait Jokers {

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean

  // genName: -> String
  // return name of the Joker
  def getName: String

  // applyScoreWithStraight: IScore -> IScore
  // Returns new score with joker and Straight effect
  def applyScoreWithStraight(score: IScore): IScore

  // applyScoreWithDiamond: IScore -> IScore
  // Returns new score with joker and Diamond effect
  def applyScoreWithDiamond(score: IScore): IScore

  // applyScoreWithEven: IScore -> IScore
  // Returns new score with joker and Even effect
  def applyScoreWithEven(score: IScore): IScore

  // applyScoreWithFigure: IScore -> IScore
  // Returns new score with joker and Figure effect
  def applyScoreWithFigure(score: IScore): IScore
}
