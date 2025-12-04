package model.cards.range.odd

import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}
import model.score.Score

class NineTest extends munit.FunSuite {

  var nine: Nine = _

  override def beforeEach(context: BeforeEach): Unit = {
    nine = new Nine()
  }

  test("equals") {
    val expected = new Nine()
    assertEquals(expected, nine)
  }

  test("getName") {
    val expected = "Nine"
    assertEquals(expected, nine.getName)
  }

  test("getOrder") {
    val expected = 9
    assertEquals(expected, nine.getOrder)
  }

  test("getValue") {
    val expected = 9
    assertEquals(expected, nine.getValue)
  }

  test("getTypeOfRange") {
    val expected = "Odd"
    assertEquals(expected, nine.getTypeOfRange)
  }
  
  test("applyScore"){
    val expected00 = Score(0, 0)
    assertEquals(nine.applyScore(Score(0,0), DeviousJoker()), expected00)
    val expected305 = Score(30, 5)
    assertEquals(nine.applyScore(Score(30,5), GreedyJoker()), expected305)
    val expected3000 = Score(300, 0)
    assertEquals(nine.applyScore(Score(300,0), EvenSteven()), expected3000)
    val expected451 = Score(45, 1)
    assertEquals(nine.applyScore(Score(45, 1), ScaryFace()), expected451)
  }
}