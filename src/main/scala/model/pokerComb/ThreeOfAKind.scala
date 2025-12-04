package model.pokerComb

import model.score.Score
import model.cards.ICards

/*
 ThreeOfAKind: Three cards of the same rank.
 */
class ThreeOfAKind extends AbstractPokerComb("Three Of A Kind", Score(30, 3)){

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[ThreeOfAKind]) {
      val thatThreeOfAKind = that.asInstanceOf[ThreeOfAKind]
      thatThreeOfAKind.getName == "Three Of A Kind" &&
      thatThreeOfAKind.getScore.equals(Score(30, 3))
    } else {
      false
    }
  }

  // verifyCards: List[ICards] -> Boolean
  // check if a list of cards meets (or does not meet)
  // the combination condition
  def verifyCards(listCards: List[ICards]): Boolean = {
    if (listCards.length >= 3) {
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
        if (cnt >= 3) {
          bool = true
        }
      }
      bool
    } else {
      false
    }
  }
}
