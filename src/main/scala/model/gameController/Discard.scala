package model.gameController

/*
discard is a state that discards the selected index
 */
class Discard (val controller: GameController) extends State() {
  controller.hand.discard(controller.selectedIndex)
  controller.selectedIndex = List()

  // fillHand: ->
  // it trow an error because from a general state
  // you cannot get to play
  override def fillHand(): Unit = {
    controller.state = new FillHand(controller)
  }

  // inDiscard: -> Boolean
  // return true if asked if the status is Discard
  override def inDiscard: Boolean = true
}
