package model.gameController

abstract class State extends GameState {
  
  // play: ->
  // it trow an error because from a general state
  // you cannot get to play
  def play(): Unit = {
    throw new Exception("Now you can't play")
  }

  // discard: ->
  // it trow an error because from a general state
  // you cannot get to play
  def discard(): Unit = {
    throw new Exception("Now you can't discard")
  }

  // startShift: ->
  // it trow an error because from a general state
  // you cannot get to play
  def fillHand(): Unit = {
    throw new Exception("Now you can't start new shift")
  }

  // finish: ->
  // it trow an error because from a general state
  // you cannot get to play
  def finish(): Unit = {
    throw new Exception("Now you can't finish")
  }

  // discard: ->
  // changes to SelectIndex state
  def selectedIndex(indexes: String): Unit = {
    throw new Exception("Now you can't select indexes")
  }
  
  // inFinish: -> Boolean
  // return false if asked if the status is finish
  def inFinish: Boolean = false

  // inDiscard: -> Boolean
  // return false if asked if the status is Discard
  def inDiscard: Boolean = false

  // inFillHand: -> Boolean
  // return false if asked if the status is FillHand
  def inFillHand: Boolean = false

  // inPlay: -> Boolean
  // return false if asked if the status is Play: 
  def inPlay: Boolean = false

  // inSelectedIndex: -> Boolean
  // return false if asked if the status is SelectedIndex
  def inSelectedIndex: Boolean = false

  // inStart: -> Boolean
  // return false if asked if the state is Start
  def inStart: Boolean = false
}
