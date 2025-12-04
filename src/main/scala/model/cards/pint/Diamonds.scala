package model.cards.pint

import model.jokers.Jokers
import model.score.{IScore, Score}

/*
Diamonds is a pint of cards
*/
class Diamonds extends AbstractPint("Diamonds") {

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[Diamonds]) {
      val thatDiamonds = that.asInstanceOf[Diamonds]
      thatDiamonds.getName == "Diamonds"
    } else {
      false
    }
  }

  // IScore, Jokers -> IScore
  // The score of a pint is calculated, given a score and a joker.
  override def applyScore(score: IScore, j: Jokers): IScore = {
    j.applyScoreWithDiamond(score)
  }
  
}
