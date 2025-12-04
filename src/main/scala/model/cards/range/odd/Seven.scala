package model.cards.range.odd

/*
 Seven is an odd rank of order 7 and value 7
 */
class Seven extends Odd("Seven", 7, 7) {

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[Seven]) {
      val thatSeven = that.asInstanceOf[Seven]
      thatSeven.getName == "Seven" &&
        thatSeven.getOrder == 7 &&
        thatSeven.getValue == 7 &&
        thatSeven.getTypeOfRange == "Odd"
    } else {
      false
    }
  }
}
