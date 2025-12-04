package model.jokers

import model.score.IScore

/*
 Abstract Class Jokers 
 are special cards that are not played as part of the poker hand,
 but remain active, modifying the scoring rules.
 */
abstract class AbstractJokers(private val name: String) extends Jokers {

  // genName: -> String
  // return name of the Joker
  def getName: String = name

  // applyScoreWithStraight: IScore -> IScore
  // Returns new score with joker and Straight effect
  def applyScoreWithStraight(score: IScore): IScore = score

  // applyScoreWithDiamond: IScore -> IScore
  // Returns new score with joker and Diamond effect
  def applyScoreWithDiamond(score: IScore): IScore = score

  // applyScoreWithEven: IScore -> IScore
  // Returns new score with joker and Even effect
  def applyScoreWithEven(score: IScore): IScore = score

  // applyScoreWithFigure: IScore -> IScore
  // Returns new score with joker and Figure effect
  def applyScoreWithFigure(score: IScore): IScore = score
}
