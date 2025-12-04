package model.cards.range.even

/*
Four is an odd rank of order 4 and value 4
*/
class Four extends Even("Four", 4, 4) {
  
  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[Four]) {
      val thatFour = that.asInstanceOf[Four]
      thatFour.getName == "Four" &&
        thatFour.getOrder == 4 &&
        thatFour.getValue == 4 &&
        thatFour.getTypeOfRange == "Even"
    } else {
      false
    }
  }
}
