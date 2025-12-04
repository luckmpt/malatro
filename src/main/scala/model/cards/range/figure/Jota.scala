package model.cards.range.figure

/*
Jota is a rank of figure of order 11 and value 10
*/
class Jota extends Figure("Jota", 11, 10) {
  
  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[Jota]) {
      val thatJota = that.asInstanceOf[Jota]
      thatJota.getName == "Jota" &&
        thatJota.getOrder == 11 &&
        thatJota.getValue == 10 &&
        thatJota.getTypeOfRange == "Figure"
    } else {
      false
    }
  }
}
