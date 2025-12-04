package model.cards.range.even

/*
Two is an odd rank of order 2 and value 2
*/
class Two extends Even("Two", 2, 2) {

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[Two]) {
      val thatTwo = that.asInstanceOf[Two]
      thatTwo.getName == "Two" &&
        thatTwo.getOrder == 2 &&
        thatTwo.getValue == 2 &&
        thatTwo.getTypeOfRange == "Even"
    } else {
      false
    }
  }
}
