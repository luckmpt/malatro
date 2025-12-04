package model.cards.range.odd

import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}
import model.score.Score

class SevenTest extends munit.FunSuite {

  var seven: Seven = _

  override def beforeEach(context: BeforeEach): Unit = {
    seven = new Seven()
  }

  test("equals") {
    val expected = new Seven()
    assertEquals(expected, seven)
  }

  test("getName") {
    val expected = "Seven"
    assertEquals(expected, seven.getName)
  }

  test("getOrder") {
    val expected = 7
    assertEquals(expected, seven.getOrder)
  }

  test("getValue") {
    val expected = 7
    assertEquals(expected, seven.getValue)
  }

  test("getTypeOfRange") {
    val expected = "Odd"
    assertEquals(expected, seven.getTypeOfRange)
  }
  
  test("applyScore"){
    val expected00 = Score(0, 0)
    assertEquals(seven.applyScore(Score(0,0), DeviousJoker()), expected00)
    val expected305 = Score(30, 5)
    assertEquals(seven.applyScore(Score(30,5), GreedyJoker()), expected305)
    val expected3000 = Score(300, 0)
    assertEquals(seven.applyScore(Score(300,0), EvenSteven()), expected3000)
    val expected451 = Score(45, 1)
    assertEquals(seven.applyScore(Score(45, 1), ScaryFace()), expected451)
  }
}