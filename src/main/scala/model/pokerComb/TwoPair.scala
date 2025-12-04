package model.pokerComb

import model.score.Score
import model.cards.ICards

/*
 TwoPair: Two cards of the same rank.
 */
class TwoPair extends AbstractPokerComb("Two Pair", Score(20, 2)){

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[TwoPair]) {
      val thatTwoPair = that.asInstanceOf[TwoPair]
      thatTwoPair.getName == "Two Pair"
      thatTwoPair.getScore.equals(Score(20, 2))
    } else {
      false
    }
  }

  // verifyCards: List[ICards] -> Boolean
  // check if a list of cards meets (or does not meet)
  // the combination condition
  def verifyCards(listCards: List[ICards]): Boolean = {
    if (listCards.length >= 4) {
      val rangeCards = listCards.map(x => x.getRange.getOrder).sorted
      var cnt = 0
      var r = 0
      var pairs = 0
      for (range <- rangeCards) {
        if (range == r) {
          cnt += 1
        } else {
          r = range
          cnt = 1
        }
        if (cnt >= 2) {
          pairs += 1
          r = 0
          cnt = 0
        }
      }
      pairs >= 2
    } else {
      false
    }
  }
}
