package model.gameController

import model.cards.ICards
import model.hand.Hand
import model.score.IScore

/*
play is a state that plays the selected index
 */
class Play(val controller: GameController) extends State() {
  private val cardsPlayed: List[ICards] = controller.hand.play(controller.selectedIndex)
  controller.selectedIndex = List()
  val score: IScore = Hand(cardsPlayed, controller.hand.getJokers).applyScore
  controller.score += score.getScore

  // startShift: ->
  // it trow an error because from a general state
  // you cannot get to play
  override def fillHand(): Unit = {
    if (controller.bool) {
      controller.state = new Finish(controller)
    } else {
      controller.state = new FillHand(controller)
    }
  }

  // inPlay: -> Boolean
  // return true if asked if the status is Play
  override def inPlay: Boolean = true
}
