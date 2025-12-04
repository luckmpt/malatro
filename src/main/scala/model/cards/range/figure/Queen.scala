package model.cards.range.figure

/*
Queen is a rank of figure of order 12 and value 10
 */
class Queen extends Figure("Queen", 12, 10) {

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[Queen]) {
      val thatQueen = that.asInstanceOf[Queen]
      thatQueen.getName == "Queen" &&
        thatQueen.getOrder == 12 &&
        thatQueen.getValue == 10 &&
        thatQueen.getTypeOfRange == "Figure"
    } else {
      false
    }
  }

}
