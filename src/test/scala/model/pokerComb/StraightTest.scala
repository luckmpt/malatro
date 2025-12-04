package model.pokerComb

import model.score.Score
import model.cards.Cards
import model.cards.pint.{Clubs, Hearts, Spades}
import model.cards.range.even.{Four, Two}
import model.cards.range.figure.King
import model.cards.range.odd.{As, Seven, Three}
import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}

class StraightTest extends munit.FunSuite {

  var straight: Straight = _

  override def beforeEach(context: BeforeEach): Unit = {
    straight = new Straight()
  }

  test("equals") {
    val expected = new Straight()
    assertEquals(expected, straight)
  }

  test("getName") {
    val expected = "Straight"
    assertEquals(expected, straight.getName)
  }

  test("getScore") {
    val expected = Score(30, 4)
    assertEquals(straight.getScore, expected)
  }

  test("verifyCards") {
    val cardsTrue = List(
      Cards(Two(), Hearts()),
      Cards(Three(), Clubs()),
      Cards(As(), Spades()),
      Cards(King(), Clubs()),
      Cards(Four(), Hearts())
    )
    val expected1 = true
    assertEquals(expected1, straight.verifyCards(cardsTrue))
    val cardsFalse = List(
      Cards(Two(), Hearts()),
      Cards(Three(), Clubs()),
      Cards(As(), Spades()),
      Cards(King(), Clubs()),
      Cards(Seven(), Hearts())
    )
    val expected2 = false
    assertEquals(expected2, straight.verifyCards(cardsFalse))
  }

  test("applyScore"){
    val expected00 = Score(0,0)
    assertEquals(straight.applyScore(Score(0,0), GreedyJoker()), expected00)
    val expected305 = Score(30,5)
    assertEquals(straight.applyScore(Score(30,5), GreedyJoker()), expected305)
    val expected3000 = Score(300,0)
    assertEquals(straight.applyScore(Score(300,0), EvenSteven()), expected3000)
    val expected451 = Score(45, 1)
    assertEquals(straight.applyScore(Score(45, 1), ScaryFace()), expected451)
    val expectedEsp1 = Score(100,0)
    assertEquals(straight.applyScore(Score(0,0), DeviousJoker()), expectedEsp1)
    val expectedEsp2 = Score(150, 5)
    assertEquals(straight.applyScore(Score(50, 5), DeviousJoker()), expectedEsp2)
  }
}
