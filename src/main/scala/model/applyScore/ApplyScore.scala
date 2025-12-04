package model.applyScore

import model.jokers.Jokers
import model.score.IScore

/*
ApplyScore: Interface containing applyScore that
receives a score, a joker, and returns a new score
*/
trait ApplyScore {
  
  // IScore, Jokers -> IScore
  // The score del objeto, given a  based score and a joker
  def applyScore(score: IScore, j: Jokers): IScore

}
