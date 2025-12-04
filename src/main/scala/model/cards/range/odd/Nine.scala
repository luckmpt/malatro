package model.cards.range.odd

/*
Nine is an odd rank of order 9 and value 9
 */
class Nine extends Odd("Nine", 9, 9) {

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[Nine]) {
      val thatNine = that.asInstanceOf[Nine]
      thatNine.getName == "Nine" &&
        thatNine.getOrder == 9 &&
        thatNine.getValue == 9 &&
        thatNine.getTypeOfRange == "Odd"
    } else {
      false
    }
  }
}
