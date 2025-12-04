package model.pokerComb

import model.cards.Cards
import model.cards.pint.{Hearts, Spades}
import model.cards.range.even.Two
import model.cards.range.figure.Jota
import model.cards.range.odd.{As, Seven}
import model.score.Score
import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}

class FlushTest extends munit.FunSuite {

  var flush: Flush = _

  override def beforeEach(context: BeforeEach): Unit = {
    flush = new Flush()
  }

  test("equals") {
    val expected = new Flush()
    assertEquals(expected, flush)
  }

  test("getName") {
    val expected = "Flush"
    assertEquals(expected, flush.getName)
  }

  test("getScore") {
    val expected = Score(35, 4)
    assertEquals(flush.getScore, expected)
  }

  test("verifyCards") {
    val cardsTrue = List(
      Cards(Two(), Hearts()),
      Cards(Jota(), Hearts()),
      Cards(As(), Hearts()),
      Cards(Seven(), Hearts()),
      Cards(Two(), Hearts())
    )
    val expected1 = true
    assertEquals(expected1, flush.verifyCards(cardsTrue))
    val cardsFalse = List(
      Cards(Two(), Hearts()),
      Cards(Jota(), Hearts()),
      Cards(As(), Hearts()),
      Cards(Seven(), Spades()),
      Cards(Two(), Hearts())
    )
    val expected2 = false
    assertEquals(expected2, flush.verifyCards(cardsFalse))
  }

  test("applyScore"){
    val expected00 = Score(0,0)
    assertEquals(flush.applyScore(Score(0,0), DeviousJoker()), expected00)
    val expected305 = Score(30,5)
    assertEquals(flush.applyScore(Score(30,5), GreedyJoker()), expected305)
    val expected3000 = Score(300,0)
    assertEquals(flush.applyScore(Score(300,0), EvenSteven()), expected3000)
    val expected451 = Score(45, 1)
    assertEquals(flush.applyScore(Score(45, 1), ScaryFace()), expected451)
  }
}
