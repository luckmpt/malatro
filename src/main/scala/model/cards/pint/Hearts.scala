package model.cards.pint

/*
Hearts is a pint of cards
*/
class Hearts extends AbstractPint("Hearts") {

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[Hearts]) {
      val thatHearts = that.asInstanceOf[Hearts]
      thatHearts.getName == "Hearts"
    } else {
      false
    }
  }
  
}
