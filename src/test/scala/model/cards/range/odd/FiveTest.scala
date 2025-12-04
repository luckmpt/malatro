package model.cards.range.odd

import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}
import model.score.Score

class FiveTest extends munit.FunSuite {

  var five: Five = _

  override def beforeEach(context: BeforeEach): Unit = {
    five = new Five()
  }

  test("equals") {
    val expected = new Five()
    assertEquals(expected, five)
  }

  test("getName") {
    val expected = "Five"
    assertEquals(expected, five.getName)
  }

  test("getOrder") {
    val expected = 5
    assertEquals(expected, five.getOrder)
  }

  test("getValue") {
    val expected = 5
    assertEquals(expected, five.getValue)
  }

  test("getTypeOfRange") {
    val expected = "Odd"
    assertEquals(expected, five.getTypeOfRange)
  }
  
  test("applyScore"){
    val expected00 = Score(0, 0)
    assertEquals(five.applyScore(Score(0,0), DeviousJoker()), expected00)
    val expected305 = Score(30, 5)
    assertEquals(five.applyScore(Score(30,5), GreedyJoker()), expected305)
    val expected3000 = Score(300, 0)
    assertEquals(five.applyScore(Score(300,0), EvenSteven()), expected3000)
    val expected451 = Score(45, 1)
    assertEquals(five.applyScore(Score(45, 1), ScaryFace()), expected451)
  }
}