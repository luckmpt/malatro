package model.cards.range.figure

/*
King is a rank of figure of order 13 and value 10
 */

class King extends Figure("King", 13, 10) {

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[King]) {
      val thatKing = that.asInstanceOf[King]
      thatKing.getName == "King" &&
        thatKing.getOrder == 13 &&
        thatKing.getValue == 10 &&
        thatKing.getTypeOfRange == "Figure"
    } else {
      false
    }
  }

}
