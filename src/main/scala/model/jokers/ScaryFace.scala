package model.jokers

import model.score.{IScore, Score}

/*
 Si las cartas jugadas contienen cartas con figura (J, Q, K),
 otorga +30 chips adicionales por cada una.
 */
class ScaryFace extends AbstractJokers("Scary Face"){

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[ScaryFace]) {
      val thatScaryFace = that.asInstanceOf[ScaryFace]
      thatScaryFace.getName == "Scary Face"
    } else {
      false
    }
  }

  // applyScoreWithFigure: IScore -> IScore
  // Returns new score with joker and Figure effect
  override def applyScoreWithFigure(score: IScore): IScore = {
    Score(score.getChip + 30, score.getMulti)
  }
}
