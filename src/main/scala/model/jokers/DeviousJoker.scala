package model.jokers

import model.score.{IScore, Score}

/*
 DeviousJoker is a joker cards
 If the cards played contain a straight, 
 it gives +100 additional chips to the score.
 */
class DeviousJoker extends AbstractJokers("Devious Joker"){

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[DeviousJoker]) {
      val thatDeviousJoker = that.asInstanceOf[DeviousJoker]
      thatDeviousJoker.getName == "Devious Joker"
    } else {
      false
    }
  }

  // applyScoreWithStraight: IScore -> IScore
  // Returns new score with joker and Straight effect
  override def applyScoreWithStraight(score: IScore): IScore = {
    Score(score.getChip+100, score.getMulti)
  }
}
