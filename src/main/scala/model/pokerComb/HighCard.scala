package model.pokerComb

import model.score.Score
import model.cards.ICards

/*
 HighCard: Five cards in consecutive order, regardless of suit.
 */
class HighCard extends AbstractPokerComb("High Card", Score(5, 1)){

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[HighCard]) {
      val thatHighCard = that.asInstanceOf[HighCard]
      thatHighCard.getName == "Straight"
      thatHighCard.getScore.equals(Score(5, 1))
    } else {
      false
    }
  }

  // verifyCards: List[ICards] -> Boolean
  // check if a list of cards meets (or does not meet)
  // the combination condition
  def verifyCards(listCards: List[ICards]): Boolean = {
    !(Pair().verifyCards(listCards) ||
      TwoPair().verifyCards(listCards) ||
      ThreeOfAKind().verifyCards(listCards) ||
      Straight().verifyCards(listCards) ||
      Flush().verifyCards(listCards) ||
      FullHouse().verifyCards(listCards) ||
      FourOfAKind().verifyCards(listCards) ||
      StraightFlush().verifyCards(listCards)) &&
      listCards.nonEmpty
  }
}
