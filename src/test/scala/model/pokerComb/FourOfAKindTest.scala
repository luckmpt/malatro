package model.pokerComb

import model.score.Score
import model.cards.Cards
import model.cards.pint.{Clubs, Hearts, Spades}
import model.cards.range.even.Two
import model.cards.range.odd.Seven
import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}

class FourOfAKindTest extends munit.FunSuite {

  var fourOfAKind: FourOfAKind = _

  override def beforeEach(context: BeforeEach): Unit = {
    fourOfAKind = new FourOfAKind()
  }

  test("equals") {
    val expected = new FourOfAKind()
    assertEquals(expected, fourOfAKind)
  }

  test("getName") {
    val expected = "Four Of A Kind"
    assertEquals(expected, fourOfAKind.getName)
  }

  test("getScore") {
    val expected = Score(60, 7)
    assertEquals(fourOfAKind.getScore, expected)
  }

  test("verifyCards") {
    val cardsTrue = List(
      Cards(Two(), Hearts()),
      Cards(Two(), Clubs()),
      Cards(Two(), Hearts()),
      Cards(Two(), Hearts()),
    )
    val expected1 = true
    assertEquals(expected1, fourOfAKind.verifyCards(cardsTrue))
    val cardsFalse = List(
      Cards(Two(), Hearts()),
      Cards(Two(), Clubs()),
      Cards(Two(), Hearts()),
      Cards(Seven(), Spades()),
    )
    val expected2 = false
    assertEquals(expected2, fourOfAKind.verifyCards(cardsFalse))
  }

  test("applyScore"){
    val expected00 = Score(0,0)
    assertEquals(fourOfAKind.applyScore(Score(0,0), DeviousJoker()), expected00)
    val expected305 = Score(30,5)
    assertEquals(fourOfAKind.applyScore(Score(30,5), GreedyJoker()), expected305)
    val expected3000 = Score(300,0)
    assertEquals(fourOfAKind.applyScore(Score(300,0), EvenSteven()), expected3000)
    val expected451 = Score(45, 1)
    assertEquals(fourOfAKind.applyScore(Score(45, 1), ScaryFace()), expected451)
  }
}