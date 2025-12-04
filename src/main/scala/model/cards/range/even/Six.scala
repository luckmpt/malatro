package model.cards.range.even

/*
Six is an odd rank of order 6 and value 6
*/
class Six extends Even("Six", 6, 6) {
  
  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[Six]) {
      val thatSix = that.asInstanceOf[Six]
      thatSix.getName == "Six" &&
        thatSix.getOrder == 6 &&
        thatSix.getValue == 6 &&
        thatSix.getTypeOfRange == "Even"
    } else {
      false
    }
  }
}
