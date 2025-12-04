package model.pokerComb

import model.score.{IScore, Score}
import model.cards.ICards
import model.jokers.Jokers

/*
 Straight: Five cards in consecutive order, regardless of suit.
 */
class Straight extends AbstractPokerComb("Straight", Score(30, 4)){

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[Straight]) {
      val thatStraight = that.asInstanceOf[Straight]
      thatStraight.getName == "Straight" &&
      thatStraight.getScore.equals(Score(30, 4))
    } else {
      false
    }
  }

  // verifyCards: List[ICards] -> Boolean
  // check if a list of cards meets (or does not meet)
  // the combination condition
  def verifyCards(listCards: List[ICards]): Boolean = {
    if (listCards.length >= 5) {
      val ranges = listCards.map(x => x.getRange.getOrder)
      val rangeSorted = ranges.sorted
      var bool = false
      var i = 0
      var j = 0
      var consecutivos = 0
      var observados = 0
      while (observados <= rangeSorted.length*2) {
        if (rangeSorted(j) != i){
          consecutivos = 1
          i = rangeSorted(j)
        } else {
          consecutivos += 1
          if (consecutivos >= 5){
            bool = true
          }
        }
        observados += 1
        if (i == 13) {
          i = 1
        } else {
          i += 1
        }
        if (j == rangeSorted.length-1){
          j = 0
        } else {
          j += 1
        }
      }
      bool
    } else {false}
  }

  // IScore, Jokers -> IScore
  // The score of a poker combination is calculated,
  // given a score and a joker
  override def applyScore(score: IScore, j: Jokers): IScore = {
    j.applyScoreWithStraight(score)
  }
}
