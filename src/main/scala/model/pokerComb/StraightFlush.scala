package model.pokerComb

import model.score.{IScore, Score}
import model.cards.ICards
import model.jokers.Jokers

/*
 StraightFlush: straight of five consecutive cards of the same suit
 */
class StraightFlush extends AbstractPokerComb("Straight Flush", Score(100, 8)){

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[StraightFlush]) {
      val thatStraightFlush = that.asInstanceOf[StraightFlush]
      thatStraightFlush.getName == "Straight Flush" &&
      thatStraightFlush.getScore.equals(Score(100, 8))
    } else {
      false
    }
  }

  // verifyCards: List[ICards] -> Boolean
  // check if a list of cards meets (or does not meet) 
  // the combination condition
  def verifyCards(listCards: List[ICards]): Boolean = {
    if (listCards.length >= 5) {
      val clubs = listCards.filter(x => x.getPint.getName == "Clubs")
      val diamonds = listCards.filter(x => x.getPint.getName == "Diamonds")
      val hearts = listCards.filter(x => x.getPint.getName == "Hearts")
      val spades = listCards.filter(x => x.getPint.getName == "Spades")
      var bool = false
      if (clubs.length >= 5){
        if (Straight().verifyCards(clubs)){
          bool = true
        }
      }
      if (diamonds.length >= 5){
        if (Straight().verifyCards(diamonds)){
          bool = true
        }
      }
      if (hearts.length >= 5){
        if (Straight().verifyCards(hearts)){
          bool = true
        }
      }
      if (spades.length >= 5){
        if (Straight().verifyCards(spades)){
          bool = true
        }
      }
      bool
    } else {
      false
    }
  }

  // IScore, Jokers -> IScore
  // The score of a poker combination is calculated,
  // given a score and a joker
  override def applyScore(score: IScore, j: Jokers): IScore = {
    j.applyScoreWithStraight(score)
  }
}
