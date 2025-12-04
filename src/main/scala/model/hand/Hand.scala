package model.hand
import model.cards.ICards
import model.jokers.Jokers
import model.pokerComb.{Flush, FourOfAKind, FullHouse, HighCard, Pair, PokerComb, Straight, StraightFlush, ThreeOfAKind, TwoPair}
import model.score.{IScore, Score}

/*
 Class Hand:
 The player has a hand consisting of at most 8
 cards and 2 jokers.
 */
class Hand(
    private var cards: List[ICards],
    private var jokers: List[Jokers]) extends IHand {

  private var played: Int = 0
  private var discarded: Int = 0

  // getCards: -> List[ICards]
  // return list of cards in hand
  def getCards: List[ICards] = cards

  // getJokers: -> List[Jokers]
  // return list of jokers in hand
  def getJokers: List[Jokers] = jokers
  
  // getDiscarded: -> Int
  // return discarded
  def getDiscarded: Int = discarded
  
  // getPlayed: -> Int
  // return played
  def getPlayed = played

  // equals: Any -> Boolean
  // receives any object and returns True
  // if it is equal to the called object
  override def equals(that: Any): Boolean = {
    if (that.isInstanceOf[Hand]) {
      val thatCards = that.asInstanceOf[Hand]
      thatCards.getCards.equals(cards) &&
        thatCards.getJokers.equals(jokers)
    } else {
      false
    }
  }

  // addCard: ICard ->
  // receive a card and add it to your hand
  def addCard(card: ICards): Unit = {
    if (cards.length < 8) {
      cards = cards :+ card
    } else {
      throw new Exception("A hand cannot have more than 8 cards.")
    }
  }

  // removeCard: int ->
  // receive an index and remove the card located at that index
  def removeCard(i: Int): Unit = {
    if (i < cards.length && i >= 0){
      val (first, second) = cards.splitAt(i)
      cards = first ++ second.tail
    } else {
      throw new Exception("You cannot remove a card that is not in your hand. (Invalid index)")
    }
  }

  // addJoker: Jokers ->
  // receive a joker and add it to your hand
  def addJoker(joker: Jokers): Unit = {
    if (jokers.length < 2){
      jokers = jokers :+ joker
    } else {
      throw new Exception("A hand cannot have more than 2 jokers.")
    }
  }

  // removeJoker: int ->
  // receive an index and remove the Joker located at that index
  def removeJoker(i: Int): Unit = {
    if (i < jokers.length && i >= 0) {
      val (first, second) = jokers.splitAt(i)
      jokers = first ++ second.tail
    } else {
      throw new Exception("You cannot remove a joker that is not in your hand. (Invalid index)")
    }
  }

  // play: List[Int] -> List[Cards]
  // receives a list of indices corresponding to
  // the cards to be played.
  // returns the list of cards corresponding to
  // the indices and removes them from the hand.
  def play(indices: List[Int]): List[ICards] = {
    var validated = true
    for (ind <- indices){
      if (ind >= cards.length || ind < 0) {
        validated = false
      }
    }
    if (played < 3 && indices.length <= 5 && indices.nonEmpty && validated){
      played += 1
      if (played >= 3){
        notifyObservers(true)
      }
      val selectedCards = indices.flatMap(i => cards.lift(i))
      cards = cards.zipWithIndex.filterNot { case (_, index) => indices.contains(index) }.map(_._1)
      selectedCards
    } else {
      if (played >= 3){
        throw new Exception("You cannot play a set of cards more than 3 times.")
      } else {
        if (indices.length > 5){
          throw new Exception("You cannot play more than 5 cards.")
        } else {
          if(indices.isEmpty) {
            throw new Exception("You cannot play less than 1 card.")
          } else {
            throw new Exception("You cannot play a list of invalid (out-of-range) indexes.")
          }
        }
      }
    }
  }

  //Discard: List[Int] ->
  // Receive a list of indices and discard the cards corresponding
  // to these indices
  def discard(indices: List[Int]): Unit = {
    var validated = true
    for (ind <- indices){
      if (ind >= cards.length || ind < 0) {
        validated = false
      }
    }
    if (discarded < 3 && indices.length <= 5 && indices.nonEmpty && validated){
      discarded += 1
      cards = cards.zipWithIndex.filterNot { case (_, index) => indices.contains(index) }.map(_._1)
    } else {
      if (discarded >= 3){
        throw new Exception("You cannot discard a set of cards more than 3 times.")
      } else {
        if (indices.length > 5){
          throw new Exception("You cannot discard more than 5 cards.")
        } else {
          if(indices.isEmpty) {
            throw new Exception("You cannot discard fewer than 1 card.")
          } else {
            throw new Exception("You cannot discard a list of invalid (out-of-range) indexes.")
          }
        }
      }
    }
  }

  // detectedCombination: -> PokerComb
  // detects the poker combination of the hand
  def detectCombination: PokerComb = {
    var pokerComb: PokerComb = StraightFlush()
    if (!pokerComb.verifyCards(cards)) {
      pokerComb = FourOfAKind()
      if (!pokerComb.verifyCards(cards)) {
        pokerComb = FullHouse()
        if (!pokerComb.verifyCards(cards)) {
          pokerComb = Flush()
          if (!pokerComb.verifyCards(cards)) {
            pokerComb = Straight()
            if (!pokerComb.verifyCards(cards)) {
              pokerComb = ThreeOfAKind()
              if (!pokerComb.verifyCards(cards)) {
                pokerComb = TwoPair()
                if (!pokerComb.verifyCards(cards)) {
                  pokerComb = Pair()
                  if (!pokerComb.verifyCards(cards))
                    pokerComb = HighCard()
                }
              }
            }
          }
        }
      }
    }
    pokerComb
  }

  // applyScore: -> Score
  // Returns the score of the hand played
  def applyScore: IScore = {
    val pokerComb: PokerComb = this.detectCombination
    var score: IScore = pokerComb.getScore
    for (joker <- jokers) {
      score = pokerComb.applyScore(score, joker)
    }
    for (card <- cards){
      score = card.applyScore(score, jokers)
    }
    score
  }
}