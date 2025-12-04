package model.cards

import model.cards.pint.*
import model.cards.range.Range
import model.cards.range.even.{Eight, Four, Six, Two}
import model.cards.range.figure.{Jota, King, Queen}
import model.cards.range.odd.*
import model.cards.{Cards, ICards}
import model.jokers.*

import scala.util.Random

// Deck of cards, contains all the poker cards

object Deck {
  val ranges: List[Range] = List(
    As(),
    Two(),
    Three(),
    Four(),
    Five(),
    Six(),
    Seven(),
    Eight(),
    Nine(),
    Jota(),
    Queen(),
    King()
  )
  val pints: List[Pint] = List(
    Diamonds(),
    Clubs(),
    Hearts(),
    Spades()
  )
  var cards: List[ICards] = List()
  for (pint <- pints) {
    for (range <- ranges){
      cards :+= Cards(range, pint)
    }
  }
  val jokers: List[Jokers] = List(
    DeviousJoker(),
    EvenSteven(),
    GreedyJoker(),
    ScaryFace()
  )
  
  // drowCard: -> ICards
  // deal a card at random from the deck
  def drawCard: ICards = {
    val rand = new Random()
    val i: Int = rand.nextInt(cards.length)
    cards(i)
  }

  // drowJoker: -> Jokers
  // deal a joker at random from the deck
  def drawJoker: Jokers = {
    val rand = new Random()
    val i: Int = rand.nextInt(jokers.length)
    jokers(i)
  }
}
