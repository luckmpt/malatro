package model.jokers

import model.score.{IScore, Score}

/* EvenSteven is a joker cards
 Si las cartas jugadas contienen cartas de rango par, 
 otorga +4 al multiplicador por cada una.
 */
class EvenSteven extends AbstractJokers("Even Steven"){
  
  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[EvenSteven]) {
      val thatEvenSteven = that.asInstanceOf[EvenSteven]
      thatEvenSteven.getName == "Even Steven"
    } else {
      false
    }
  }

  // applyScoreWithEven: IScore -> IScore
  // Returns new score with joker and Even effect
  override def applyScoreWithEven(score: IScore): IScore = {
    Score(score.getChip, score.getMulti + 4)
  }
}
