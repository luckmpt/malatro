package model.gameController

import model.cards.Deck

/*
FillHand is a state that filling the hand. Can move to SelectedIndex State
with the indexes of argument
 */
class FillHand(val controller: GameController) extends State() {
  while (controller.hand.getCards.length < 8) {
    controller.hand.addCard(Deck.drawCard)
  }
  while (controller.hand.getJokers.length < 2) {
    controller.hand.addJoker(Deck.drawJoker)
  }

  // discard: ->
  // changes to SelectIndex state
  // most recibe indexes in a string separated for spaces
  override def selectedIndex(indexes: String): Unit = {
    controller.state = new SelectIndex(controller, indexes)
  }

  // inFillHand: -> Boolean
  // return true if asked if the status is FillHand
  override def inFillHand: Boolean = true
}