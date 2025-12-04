package model.gameController

/*
Start is the first state of game
 */
class Start(controller: GameController) extends State{
  // fillHand: ->
  // it trow an error because from a general state
  // you cannot get to play
  override def fillHand(): Unit = {
    controller.state = new FillHand(controller)
  }

  // inStart: -> Boolean
  // return true if asked if the status is Start
  override def inStart: Boolean = true
}
