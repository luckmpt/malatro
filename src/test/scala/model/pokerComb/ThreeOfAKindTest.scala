package model.pokerComb

import model.score.Score
import model.cards.Cards
import model.cards.pint.{Clubs, Hearts, Spades}
import model.cards.range.even.Two
import model.cards.range.odd.Seven
import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}

class ThreeOfAKindTest extends munit.FunSuite {

  var threeOfAKind: ThreeOfAKind = _

  override def beforeEach(context: BeforeEach): Unit = {
    threeOfAKind = new ThreeOfAKind()
  }

  test("equals") {
    val expected = new ThreeOfAKind()
    assertEquals(expected, threeOfAKind)
  }

  test("getName") {
    val expected = "Three Of A Kind"
    assertEquals(expected, threeOfAKind.getName)
  }

  test("getScore") {
    val expected = Score(30, 3)
    assertEquals(threeOfAKind.getScore, expected)
  }

  test("verifyCards") {
    val cardsTrue = List(
      Cards(Two(), Hearts()),
      Cards(Two(), Clubs()),
      Cards(Two(), Hearts()),
    )
    val expected1 = true
    assertEquals(expected1, threeOfAKind.verifyCards(cardsTrue))
    val cardsFalse = List(
      Cards(Two(), Hearts()),
      Cards(Two(), Clubs()),
      Cards(Seven(), Spades()),
    )
    val expected2 = false
    assertEquals(expected2, threeOfAKind.verifyCards(cardsFalse))
  }
  
    test("applyScore"){
    val expected00 = Score(0,0)
    assertEquals(threeOfAKind.applyScore(Score(0,0), DeviousJoker()), expected00)
    val expected305 = Score(30,5)
    assertEquals(threeOfAKind.applyScore(Score(30,5), GreedyJoker()), expected305)
    val expected3000 = Score(300,0)
    assertEquals(threeOfAKind.applyScore(Score(300,0), EvenSteven()), expected3000)
    val expected451 = Score(45, 1)
    assertEquals(threeOfAKind.applyScore(Score(45, 1), ScaryFace()), expected451)
  }
}