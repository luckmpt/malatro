package model.cards.range.odd

/*
// As is an odd rank of order 1 and value 11
*/
class As extends Odd("As", 1, 1) {

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[As]) {
      val thatAs = that.asInstanceOf[As]
      thatAs.getName == "As" &&
        thatAs.getOrder == 1 &&
        thatAs.getValue == 1 &&
        thatAs.getTypeOfRange == "Odd"
    } else {
      false
    }
  }

}
