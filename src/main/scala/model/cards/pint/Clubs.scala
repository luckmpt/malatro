package model.cards.pint

/*
Clubs is a pint of cards
*/
class Clubs extends AbstractPint("Clubs"){
  
  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[Clubs]) {
      val thatClubs = that.asInstanceOf[Clubs]
      thatClubs.getName == "Clubs"
    } else {
      false
    }
  }
}
