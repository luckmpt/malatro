package model.gameController

import model.hand.Hand

/*
Finish is a state that ends the game, decides whether you win or lose
 */
class Finish(val controller: GameController) extends State() {
  if (controller.score >= controller.scoreMin) {
    controller.win = true
  }
  controller.hand = new Hand(List(), List())
  controller.score = 0
  controller.selectedIndex = List()

  // inFinish: -> Boolean
  // return true if asked if the status is finish
  override def inFinish: Boolean = true

}
