package model.gameController

import model.hand.{IHand, Hand}

/*
GameController:
initializes a malatro game with all its variables, has methods to
change game states
 */
class GameController extends Observer{

  // Actual Hand
  var hand: IHand = new Hand(List(), List())
  hand.subscribe(this)
  // Selected index
  var selectedIndex: List[Int] = List()
  // actual score
  var score: Int = 0
  // minimun score to win
  val scoreMin = 1000
  // Estado actual del juego
  var state: GameState = new Start(this)
  // played limit reached
  var bool: Boolean = false
  // win?
  var win: Boolean = false

  // play: ->
  // changes to play state
  def discard(): Unit = {
    state.discard()
  }

  // discard: ->
  // changes to discard state
  def play(): Unit = {
    state.play()
  }

  // startShift: ->
  // changes to startShift state
  def fillHand(): Unit = {
    state.fillHand()
  }

  // discard: ->
  // changes to SelectIndex state
  def selectedIndex(indexes: String): Unit = {
    state.selectedIndex(indexes)
  }

  // finish: ->
  // changes to finish state
  def finish(): Unit = {
    state.finish()
  }

  // variables de estado
  def inStart: Boolean = state.inStart

  def inDiscard: Boolean = state.inDiscard

  def inPlay: Boolean = state.inPlay

  def inFillHand: Boolean = state.inFillHand

  def inSelectedIndex: Boolean = state.inSelectedIndex

  def inFinish: Boolean = state.inFinish

  def update(message: Boolean): Unit = {
    if (message){
      bool = true
    }
  }
}
