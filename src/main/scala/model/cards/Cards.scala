package model.cards
import model.cards.range.Range
import model.cards.pint.Pint
import model.jokers.Jokers
import model.score.{IScore, Score}

/*
Cards are the fundamental elements of the game.
Each card has two main attributes: range and pint.
 */
class Cards(
    private val range: Range,
    private val pint: Pint
    ) extends ICards {
    
  // getRange: -> Range
  // return range of the card
  def getRange: Range = range
    
  // getPint: -> Pint
  // return pint of the card
  def getPint: Pint = pint

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object  
  override def equals(that: Any): Boolean = {
      if (that.isInstanceOf[Cards]) {
          val thatCards = that.asInstanceOf[Cards]
          thatCards.getRange.equals(range) &&
            thatCards.getPint.equals(pint)
      } else {
          false
      }
  }

  // IScore, List[Jokers] -> IScore
  // The score del objeto, given a  based score and a list of jokers
  def applyScore(score: IScore, jokers: List[Jokers]): IScore = {
    var newScore: IScore = Score(
      score.getChip + range.getValue,
      score.getMulti
    )
    for (joker <- jokers){
      newScore = pint.applyScore(newScore, joker)
      newScore = range.applyScore(newScore, joker)
    }
    newScore
  }
}
