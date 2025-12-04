package model.hand

import model.cards.ICards
import model.gameController.Subject
import model.jokers.Jokers
import model.pokerComb.PokerComb
import model.score.IScore

/*
 Interface of Hand:
 The player has a hand consisting of at most 8
 cards and 2 jokers.
 */
trait IHand extends Subject {

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean

  // getCards: -> List[ICards]
  // return list of cards in hand
  def getCards: List[ICards]

  // getJokers: -> List[Jokers]
  // return list of jokers in hand
  def getJokers: List[Jokers]

  // addCard: ICard ->
  // receive a card and add it to your hand
  def addCard(card: ICards): Unit

  // removeCard: int ->
  // receive an index and remove the card located at that index
  def removeCard(i: Int): Unit

  // addJoker: Jokers ->
  // receive a joker and add it to your hand
  def addJoker(joker: Jokers): Unit

  // removeJoker: int ->
  // receive an index and remove the Joker located at that index
  def removeJoker(i: Int): Unit

  // play: List[Int] -> List[Cards]
  // receives a list of indices corresponding to
  // the cards to be played.
  // returns the list of cards corresponding to
  // the indices and removes them from the hand.
  def play(indices: List[Int]): List[ICards]

  //Discard: List[Int] ->
  // Receive a list of indices and discard the cards corresponding
  // to these indices
  def discard(indices: List[Int]): Unit

  // applyScore: -> Score
  // Returns the score of the hand played
  def applyScore: IScore

  // detectedCombination: -> PokerComb
  // detects the poker combination of the hand
  def detectCombination: PokerComb

  // getDiscarded: -> Int
  // return discarded
  def getDiscarded: Int

  // getPlayed: -> Int
  // return played
  def getPlayed: Int
}
