package model.cards.pint

import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}
import model.score.Score

class SpadesTest extends munit.FunSuite {

  var spade: Spades = _

  override def beforeEach(context: BeforeEach): Unit = {
    spade = new Spades()
  }

  test("equals") {
    val expected = new Spades()
    assertEquals(expected, spade)
  }

  test("getName") {
    val expected = "Spades"
    assertEquals(expected, spade.getName)
  }
  
  test("applyScore"){
    val expected00 = Score(0, 0)
    assertEquals(spade.applyScore(Score(0,0), DeviousJoker()), expected00)
    val expected305 = Score(30, 5)
    assertEquals(spade.applyScore(Score(30,5), GreedyJoker()), expected305)
    val expected3000 = Score(300, 0)
    assertEquals(spade.applyScore(Score(300,0), EvenSteven()), expected3000)
    val expected451 = Score(45, 1)
    assertEquals(spade.applyScore(Score(45, 1), ScaryFace()), expected451)
  }
}
