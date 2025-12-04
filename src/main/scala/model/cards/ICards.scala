package model.cards
import model.cards.pint.Pint
import model.cards.range.Range
import model.jokers.Jokers
import model.score.IScore

/*
interface of Cards are the fundamental elements of the game.
Each card has two main attributes: range and pint.
 */
trait ICards {

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean

  // getRange: -> Range
  // return range of the card
  def getRange: Range

  // getPint: -> Pint
  // return pint of the card
  def getPint: Pint

  // IScore, List[Jokers] -> IScore
  // The score del objeto, given a  based score and a list of jokers
  def applyScore(score: IScore, jokers: List[Jokers]): IScore

}
