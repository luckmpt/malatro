package model.jokers

import model.score.{IScore, Score}

/*
 GreedyJoker is a joker cards
 If the cards played contain Diamond cards,
 give +3 to the multiplier for each one.
 */
class GreedyJoker extends AbstractJokers("Greedy Joker") {

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[GreedyJoker]) {
      val thatGreedyJoker = that.asInstanceOf[GreedyJoker]
      thatGreedyJoker.getName == "Greedy Joker"
    } else {
      false
    }
  }

  // applyScoreWithDiamond: IScore -> IScore
  // Returns new score with joker and Diamond effect
  override def applyScoreWithDiamond(score: IScore): IScore = {
    Score(score.getChip, score.getMulti + 3)
  }
}
