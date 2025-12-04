package model.pokerComb

import model.score.Score
import model.cards.ICards

/*
 FourOfAKind: Four cards of the same rank
 */
class FourOfAKind extends AbstractPokerComb("Four Of A Kind", Score(60, 7)){

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[FourOfAKind]) {
      val thatFourOfAKind = that.asInstanceOf[FourOfAKind]
      thatFourOfAKind.getName == "Four Of A Kind" &&
      thatFourOfAKind.getScore.equals(Score(60, 7))
    } else {
      false
    }
  }

  // verifyCards: List[ICards] -> Boolean
  // check if a list of cards meets (or does not meet) 
  // the combination condition
  def verifyCards(listCards: List[ICards]): Boolean = {
    if (listCards.length >= 4){
      val rangeCards = listCards.map(x => x.getRange.getOrder).sorted
      var cnt = 0
      var r = 0
      var bool = false
      for (range <- rangeCards){
        if (range == r){
          cnt += 1
        } else {
          r = range
          cnt = 1
        }
        if (cnt >= 4){
          bool = true
        }
      }
      bool
    } else {
      false
    }
  }
}
