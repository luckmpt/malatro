package model.pokerComb

import model.score.Score
import model.cards.ICards

/*
 FullHouse: A combination of a trio and a pair
 */
class FullHouse extends AbstractPokerComb("Full House", Score(40, 4)){

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[FullHouse]) {
      val thatFullHouse = that.asInstanceOf[FullHouse]
      thatFullHouse.getName == "Full House" &&
      thatFullHouse.getScore.equals(Score(40, 4))
    } else {
      false
    }
  }

  // verifyCards: List[ICards] -> Boolean
  // check if a list of cards meets (or does not meet)
  // the combination condition
  def verifyCards(listCards: List[ICards]): Boolean = {
    if (listCards.length >= 5) {
      val rangeCards = listCards.map(x => x.getRange.getOrder).sorted
      var cnt = 0
      var r = 0
      var par = false
      var trio = false
      for (range <- rangeCards) {
        if (range == r) {
          cnt += 1
        } else {
          if (cnt >= 3) {
            trio = true
          } else {
            if (cnt >= 2) {
              par = true
            }
          }
          r = range
          cnt = 1
        }
      }
      if (cnt >= 3) {
        trio = true
      } else {
        if (cnt >= 2) {
          par = true
        }
      }
      par && trio
    } else {
      false
    }
  }
}
