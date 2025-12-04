package model.cards.range.odd

import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}
import model.score.Score

class ThreeTest extends munit.FunSuite {

  var three: Three = _

  override def beforeEach(context: BeforeEach): Unit = {
    three = new Three()
  }

  test("equals") {
    val expected = new Three()
    assertEquals(expected, three)
  }

  test("getName") {
    val expected = "Three"
    assertEquals(expected, three.getName)
  }

  test("getOrder") {
    val expected = 3
    assertEquals(expected, three.getOrder)
  }

  test("getValue") {
    val expected = 3
    assertEquals(expected, three.getValue)
  }

  test("getTypeOfRange") {
    val expected = "Odd"
    assertEquals(expected, three.getTypeOfRange)
  }
  
  test("applyScore"){
    val expected00 = Score(0, 0)
    assertEquals(three.applyScore(Score(0,0), DeviousJoker()), expected00)
    val expected305 = Score(30, 5)
    assertEquals(three.applyScore(Score(30,5), GreedyJoker()), expected305)
    val expected3000 = Score(300, 0)
    assertEquals(three.applyScore(Score(300,0), EvenSteven()), expected3000)
    val expected451 = Score(45, 1)
    assertEquals(three.applyScore(Score(45, 1), ScaryFace()), expected451)
  }
}