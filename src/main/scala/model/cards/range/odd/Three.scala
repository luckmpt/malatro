package model.cards.range.odd

/*
 Three is an odd rank of order 3 and value 3
 */
class Three extends Odd("Three", 3, 3) {

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[Three]) {
      val thatThree = that.asInstanceOf[Three]
      thatThree.getName == "Three" &&
        thatThree.getOrder == 3 &&
        thatThree.getValue == 3 &&
        thatThree.getTypeOfRange == "Odd"
    } else {
      false
    }
  }
}
