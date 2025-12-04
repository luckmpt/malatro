package model.pokerComb

import model.score.Score
import model.cards.Cards
import model.cards.pint.{Clubs, Hearts, Spades}
import model.cards.range.even.Two
import model.cards.range.figure.Jota
import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}

class PairTest extends munit.FunSuite {

  var pair: Pair = _

  override def beforeEach(context: BeforeEach): Unit = {
    pair = new Pair()
  }

  test("equals") {
    val expected = new Pair()
    assertEquals(expected, pair)
  }

  test("getName") {
    val expected = "Pair"
    assertEquals(expected, pair.getName)
  }

  test("getScore") {
    val expected = Score(10, 2)
    assertEquals(pair.getScore, expected)
  }

  test("verifyCards") {
    val cardsTrue = List(
      Cards(Two(), Hearts()),
      Cards(Two(), Clubs()),
    )
    val expected1 = true
    assertEquals(expected1, pair.verifyCards(cardsTrue))
    val cardsFalse = List(
      Cards(Two(), Hearts()),
      Cards(Jota(), Spades()),
    )
    val expected2 = false
    assertEquals(expected2, pair.verifyCards(cardsFalse))
  }

  test("applyScore"){
    val expected00 = Score(0,0)
    assertEquals(pair.applyScore(Score(0,0), DeviousJoker()), expected00)
    val expected305 = Score(30,5)
    assertEquals(pair.applyScore(Score(30,5), GreedyJoker()), expected305)
    val expected3000 = Score(300,0)
    assertEquals(pair.applyScore(Score(300,0), EvenSteven()), expected3000)
    val expected451 = Score(45, 1)
    assertEquals(pair.applyScore(Score(45, 1), ScaryFace()), expected451)
  }
}