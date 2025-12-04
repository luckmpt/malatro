package model.cards.range.even

/*
Ten is an odd rank of order 10 and value 10
*/
class Ten extends Even("Ten", 10, 10) {

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[Ten]) {
      val thatTen = that.asInstanceOf[Ten]
      thatTen.getName == "Ten" &&
        thatTen.getOrder == 10 &&
        thatTen.getValue == 10 &&
        thatTen.getTypeOfRange == "Even"
    } else {
      false
    }
  }
}
