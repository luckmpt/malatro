package model.cards.range.even
import model.cards.range.AbstractRange
import model.jokers.Jokers
import model.score.{IScore, Score}

/*
Abstract class of even ranks
*/
abstract class Even(
    private val name: String,
    private val order: Int,
    private val value: Int,
) extends AbstractRange(name, order, value, "Even"){

  // IScore, Jokers -> IScore
  // The score of a rank is calculated, taking its rank
  // type into consideration, given a score and a joker.
  override def applyScore(score: IScore, j: Jokers): IScore = {
    j.applyScoreWithEven(score)
  }
}