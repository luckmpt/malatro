package model.cards.range.figure
import model.cards.range.AbstractRange
import model.jokers.Jokers
import model.score.{IScore, Score}

/*
Abstract class of figure ranks
*/
abstract class Figure(
    private val name: String,
    private val order: Int,
    private val value: Int,
) extends AbstractRange(name, order, value, "Figure") {

  // IScore, Jokers -> IScore
  // The score of a rank is calculated, taking its rank
  // type into consideration, given a score and a joker.
  override def applyScore(score: IScore, j: Jokers): IScore = {
    j.applyScoreWithFigure(score)
  }
}
