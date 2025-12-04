package model.pokerComb

import model.score.Score
import model.cards.Cards
import model.cards.pint.{Clubs, Hearts, Spades}
import model.cards.range.even.Two
import model.cards.range.figure.Jota
import model.cards.range.odd.Seven
import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}

class FullHouseTest extends munit.FunSuite {

  var fullHouse: FullHouse = _

  override def beforeEach(context: BeforeEach): Unit = {
    fullHouse = new FullHouse()
  }

  test("equals") {
    val expected = new FullHouse()
    assertEquals(expected, fullHouse)
  }

  test("getName") {
    val expected = "Full House"
    assertEquals(expected, fullHouse.getName)
  }

  test("getScore") {
    val expected = Score(40, 4)
    assertEquals(fullHouse.getScore, expected)
  }

  test("verifyCards") {
    val cardsTrue = List(
      Cards(Two(), Hearts()),
      Cards(Jota(), Spades()),
      Cards(Two(), Clubs()),
      Cards(Jota(), Clubs()),
      Cards(Two(), Hearts())
    )
    val expected1 = true
    assertEquals(expected1, fullHouse.verifyCards(cardsTrue))
    val cardsFalse = List(
      Cards(Two(), Hearts()),
      Cards(Jota(), Spades()),
      Cards(Two(), Clubs()),
      Cards(Jota(), Clubs()),
      Cards(Seven(), Hearts())
    )
    val expected2 = false
    assertEquals(expected2, fullHouse.verifyCards(cardsFalse))
  }
  
  test("applyScore"){
    val expected00 = Score(0,0)
    assertEquals(fullHouse.applyScore(Score(0,0), DeviousJoker()), expected00)
    val expected305 = Score(30,5)
    assertEquals(fullHouse.applyScore(Score(30,5), GreedyJoker()), expected305)
    val expected3000 = Score(300,0)
    assertEquals(fullHouse.applyScore(Score(300,0), EvenSteven()), expected3000)
    val expected451 = Score(45, 1)
    assertEquals(fullHouse.applyScore(Score(45, 1), ScaryFace()), expected451)
  }
}