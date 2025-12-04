package model.score

/* 
Interface Score: is calculated by chips*mult
chips: score base of game;
multiplier: factor that multiplies the chip to calculate the final score
 */
class Score(
    private var chip: Int,
    private var multiplier: Int
    ) extends IScore{
  private var score: Int = chip*multiplier

  // getChip: -> Int
  // return Chip of Score
  def getChip: Int = chip


  // getMulti: -> Int
  // return Multiplier of Score
  def getMulti: Int = multiplier

  // getScore: -> Int
  // return Score of Score
  def getScore: Int = score

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[Score]) {
      val thatScore = that.asInstanceOf[Score]
      thatScore.getChip == chip &&
        thatScore.getMulti == multiplier &&
        thatScore.getScore == score
    } else {
      false
    }
  }
}