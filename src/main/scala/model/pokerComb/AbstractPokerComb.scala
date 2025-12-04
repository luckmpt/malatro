package model.pokerComb
import model.applyScore.ApplyScore
import model.jokers.Jokers
import model.score.{IScore, Score}

/*
 abstract class of PokerComb
 There are multiple valid poker combinations.
 Each combination has a specific condition that
 must be met to be valid and a base score
 */
abstract class AbstractPokerComb(private val name: String,
                        private val scoreComb: IScore) extends PokerComb {

  // getScore: -> IScore
  // return score of the poker combination
  def getScore: IScore = scoreComb

  // getName: -> String
  // return name of the poker combination
  def getName: String = name

  // IScore, Jokers -> IScore
  // The score of a poker combination is calculated,
  // given a score and a joker
  def applyScore(score: IScore, j: Jokers): IScore = score

}
