package model.score

/* 
Interface Score: is calculated by chips*mult
chips: score base of game;
multiplier: factor that multiplies the chip to calculate the final score
 */
trait IScore {
  
  // getChip: -> Int
  // return Chip of Score
  def getChip: Int
  
  // getMulti: -> Int
  // return Multiplier of Score
  def getMulti: Int

  // getScore: -> Int
  // return Score of Score
  def getScore: Int

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean
}
