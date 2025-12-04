package model.gameController

class SelectIndex(controller: GameController,
                  indexes: String) extends State {
  controller.selectedIndex = indexes.split(" ").toList.map(_.toInt - 1)


  // play: ->
  // changes to play state
  override def play(): Unit = {
    controller.state = new Play(controller)
  }

  // discard: ->
  // changes to discard state
  override def discard(): Unit = {
    controller.state = new Discard(controller)
  }

  // inSelectedIndex: -> Boolean
  // return true if asked if the status is SelectedIndex
  override def inSelectedIndex: Boolean = true
}
