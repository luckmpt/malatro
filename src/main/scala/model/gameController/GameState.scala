package model.gameController

/*
Interface GameState
Interface of a game state, allows switching to another state
 */
trait GameState {
  
  // play: ->
  // changes to play state
  def play(): Unit

  // discard: ->
  // changes to discard state
  def discard(): Unit

  // startShift: ->
  // changes to fillHand state
  def fillHand(): Unit

  // finish: ->
  // changes to finish state
  def finish(): Unit

  // discard: ->
  // changes to SelectIndex state
  def selectedIndex(indexes: String): Unit

  // inFinish: -> Boolean
  // verify if the status is finish
  def inFinish: Boolean

  // inDiscard: -> Boolean
  // verify if the status is Discard
  def inDiscard: Boolean

  // inFillHand: -> Boolean
  // verify if the status is FillHand
  def inFillHand: Boolean

  // inPlay: -> Boolean
  // verify if the status is Play: 
  def inPlay: Boolean

  // inSelectedIndex: -> Boolean
  // verify if the status is SelectedIndex
  def inSelectedIndex: Boolean

  // inStart: -> Boolean
  // verify if the state is Start
  def inStart: Boolean
}
