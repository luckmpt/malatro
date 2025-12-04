package model.cards.pint

/*
Spades is a pint of cards
*/
class Spades extends AbstractPint("Spades"){

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[Spades]) {
      val thatSpades = that.asInstanceOf[Spades]
      thatSpades.getName == "Spades"
    } else {
      false
    }
  }

}
