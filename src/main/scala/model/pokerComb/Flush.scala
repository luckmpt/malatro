package model.pokerComb

import model.score.Score
import model.cards.ICards

/*
 Flush: Five cards of the same suit, regardless of order.
 */
class Flush extends AbstractPokerComb("Flush", Score(35, 4)){

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[Flush]) {
      val thatFlush = that.asInstanceOf[Flush]
      thatFlush.getName == "Flush" &&
      thatFlush.getScore.equals(Score(35, 4))
    } else {
      false
    }
  }

  // verifyCards: List[ICards] -> Boolean
  // check if a list of cards meets (or does not meet)
  // the combination condition
  def verifyCards(listCards: List[ICards]): Boolean = {
    if (listCards.length >= 5){
      var c = 0
      var d = 0
      var h = 0
      var s = 0
      for (card <- listCards) {
        val pint = card.getPint.getName
        if (pint == "Clubs") {
          c += 1
        }
        if (pint == "Diamonds") {
          d += 1
        }
        if (pint == "Hearts") {
          h += 1
        }
        if (pint == "Spades") {
          s += 1
        }
      }
      if (c >= 5 || d >= 5 || h >= 5 || s >= 5){
        true
      } else {
        false
      }
    } else {
      false
    }
  }
}
