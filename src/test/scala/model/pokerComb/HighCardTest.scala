package model.pokerComb

import model.score.Score
import model.cards.Cards
import model.cards.pint.{Clubs, Hearts, Spades}
import model.cards.range.even.Two
import model.cards.range.figure.Jota
import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}

class HighCardTest extends munit.FunSuite {

  var highCard: HighCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    highCard = new HighCard()
  }

  test("equals") {
    val expected = new HighCard()
    assertEquals(expected, highCard)
  }

  test("getName") {
    val expected = "High Card"
    assertEquals(expected, highCard.getName)
  }

  test("getScore") {
    val expected = Score(5, 1)
    assertEquals(highCard.getScore, expected)
  }

  test("verifyCards") {
    val cardsTrue = List(
      Cards(Two(), Hearts())
    )
    val expected1 = true
    assertEquals(expected1, highCard.verifyCards(cardsTrue))
    val cardsFalse = List(
      Cards(Two(), Hearts()),
      Cards(Jota(), Spades()),
      Cards(Two(), Clubs()),
      Cards(Jota(), Clubs()),
      Cards(Two(), Hearts())
    )
    val expected2 = false
    assertEquals(expected2, highCard.verifyCards(cardsFalse))
  }
  
  test("applyScore"){
    val expected00 = Score(0,0)
    assertEquals(highCard.applyScore(Score(0,0), DeviousJoker()), expected00)
    val expected305 = Score(30,5)
    assertEquals(highCard.applyScore(Score(30,5), GreedyJoker()), expected305)
    val expected3000 = Score(300,0)
    assertEquals(highCard.applyScore(Score(300,0), EvenSteven()), expected3000)
    val expected451 = Score(45, 1)
    assertEquals(highCard.applyScore(Score(45, 1), ScaryFace()), expected451)
  }
}
