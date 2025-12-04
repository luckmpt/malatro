package model.pokerComb

import model.score.Score
import model.cards.ICards

/*
 Pair: Five cards in consecutive order, regardless of suit.
 */
class Pair extends AbstractPokerComb("Pair", Score(10, 2)){

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[Pair]) {
      val thatPair = that.asInstanceOf[Pair]
      thatPair.getName == "Pair" &&
      thatPair.getScore.equals(Score(10, 2))
    } else {
      false
    }
  }

  // verifyCards: List[ICards] -> Boolean
  // check if a list of cards meets (or does not meet)
  // the combination condition
  def verifyCards(listCards: List[ICards]): Boolean = {
    if (listCards.length >= 2) {
      val rangeCards = listCards.map(x => x.getRange.getOrder).sorted
      var cnt = 0
      var r = 0
      var bool = false
      for (range <- rangeCards) {
        if (range == r) {
          cnt += 1
        } else {
          r = range
          cnt = 1
        }
        if (cnt >= 2) {
          bool = true
        }
      }
      bool
    } else {
      false
    }
  }
}
