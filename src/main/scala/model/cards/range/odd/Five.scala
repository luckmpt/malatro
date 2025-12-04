package model.cards.range.odd

/*
 Five is an odd rank of order 5 and value 5
 */
class Five extends Odd("Five", 5, 5) {

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[Five]) {
      val thatFive = that.asInstanceOf[Five]
      thatFive.getName == "Five" &&
        thatFive.getOrder == 5 &&
        thatFive.getValue == 5 &&
        thatFive.getTypeOfRange == "Odd"
    } else {
      false
    }
  }
}
