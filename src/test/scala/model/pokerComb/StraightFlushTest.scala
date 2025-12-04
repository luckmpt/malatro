package model.pokerComb

import model.score.Score
import model.cards.Cards
import model.cards.pint.Hearts
import model.cards.range.even.{Four, Two}
import model.cards.range.figure.King
import model.cards.range.odd.{As, Seven, Three}
import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}

class StraightFlushTest extends munit.FunSuite {

  var straightFlush: StraightFlush = _

  override def beforeEach(context: BeforeEach): Unit = {
    straightFlush = new StraightFlush()
  }

  test("equals") {
    val expected = new StraightFlush()
    assertEquals(expected, straightFlush)
  }

  test("getName") {
    val expected = "Straight Flush"
    assertEquals(expected, straightFlush.getName)
  }

  test("getScore") {
    val expected = Score(100, 8)
    assertEquals(straightFlush.getScore, expected)
  }

  test("verifyCards") {
    val cardsTrue = List(
      Cards(Two(), Hearts()),
      Cards(Three(), Hearts()),
      Cards(As(), Hearts()),
      Cards(King(), Hearts()),
      Cards(Four(), Hearts())
    )
    val expected1 = true
    assertEquals(expected1, straightFlush.verifyCards(cardsTrue))
    val cardsFalse = List(
      Cards(Two(), Hearts()),
      Cards(Three(), Hearts()),
      Cards(As(), Hearts()),
      Cards(King(), Hearts()),
      Cards(Seven(), Hearts())
    )
    val expected2 = false
    assertEquals(expected2, straightFlush.verifyCards(cardsFalse))
  }

  test("applyScore"){
    val expected00 = Score(100,0)
    assertEquals(straightFlush.applyScore(Score(0,0), DeviousJoker()), expected00)
    val expected305 = Score(30,5)
    assertEquals(straightFlush.applyScore(Score(30,5), GreedyJoker()), expected305)
    val expected3000 = Score(300,0)
    assertEquals(straightFlush.applyScore(Score(300,0), EvenSteven()), expected3000)
    val expected451 = Score(45, 1)
    assertEquals(straightFlush.applyScore(Score(45, 1), ScaryFace()), expected451)
  }
}