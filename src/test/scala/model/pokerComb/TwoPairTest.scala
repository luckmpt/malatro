package model.pokerComb

import model.score.Score
import model.cards.Cards
import model.cards.pint.{Clubs, Hearts, Spades}
import model.cards.range.even.Two
import model.cards.range.figure.King
import model.cards.range.odd.Seven
import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}

class TwoPairTest extends munit.FunSuite {

  var twoPair: TwoPair = _

  override def beforeEach(context: BeforeEach): Unit = {
    twoPair = new TwoPair()
  }

  test("equals") {
    val expected = new TwoPair()
    assertEquals(expected, twoPair)
  }

  test("getName") {
    val expected = "Two Pair"
    assertEquals(expected, twoPair.getName)
  }

  test("getScore") {
    val expected = Score(20, 2)
    assertEquals(twoPair.getScore, expected)
  }

  test("verifyCards") {
    val cardsTrue = List(
      Cards(Two(), Hearts()),
      Cards(Two(), Clubs()),
      Cards(King(), Hearts()),
      Cards(King(), Spades()),
    )
    val expected1 = true
    assertEquals(expected1, twoPair.verifyCards(cardsTrue))
    val cardsFalse = List(
      Cards(Two(), Hearts()),
      Cards(Two(), Clubs()),
      Cards(King(), Hearts()),
      Cards(Seven(), Spades()),
    )
    val expected2 = false
    assertEquals(expected2, twoPair.verifyCards(cardsFalse))
  }

    test("applyScore"){
    val expected00 = Score(0,0)
    assertEquals(twoPair.applyScore(Score(0,0), DeviousJoker()), expected00)
    val expected305 = Score(30,5)
    assertEquals(twoPair.applyScore(Score(30,5), GreedyJoker()), expected305)
    val expected3000 = Score(300,0)
    assertEquals(twoPair.applyScore(Score(300,0), EvenSteven()), expected3000)
    val expected451 = Score(45, 1)
    assertEquals(twoPair.applyScore(Score(45, 1), ScaryFace()), expected451)
  }
}