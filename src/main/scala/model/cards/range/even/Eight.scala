package model.cards.range.even

/*
Eight is an odd rank of order 8 and value 8
*/
class Eight extends Even("Eight", 8, 8) {

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[Eight]) {
      val thatEight = that.asInstanceOf[Eight]
      thatEight.getName == "Eight" &&
        thatEight.getOrder == 8 &&
        thatEight.getValue == 8 &&
        thatEight.getTypeOfRange == "Even"
    } else {
      false
    }
  }
}
