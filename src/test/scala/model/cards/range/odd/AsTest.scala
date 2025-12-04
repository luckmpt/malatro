package model.cards.range.odd

import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}
import model.score.Score

class AsTest extends munit.FunSuite {

  var as: As = _

  override def beforeEach(context: BeforeEach): Unit = {
    as = new As()
  }

  test("equals") {
    val expected = new As()
    assertEquals(expected, as)
  }

  test("getName") {
    val expected = "As"
    assertEquals(expected, as.getName)
  }

  test("getOrder") {
    val expected = 1
    assertEquals(expected, as.getOrder)
  }

  test("getValue") {
    val expected = 1
    assertEquals(expected, as.getValue)
  }

  test("getTypeOfRange") {
    val expected = "Odd"
    assertEquals(expected, as.getTypeOfRange)
  }
  
  test("applyScore"){
    val expected00 = Score(0, 0)
    assertEquals(as.applyScore(Score(0,0), DeviousJoker()), expected00)
    val expected305 = Score(30, 5)
    assertEquals(as.applyScore(Score(30,5), GreedyJoker()), expected305)
    val expected3000 = Score(300, 0)
    assertEquals(as.applyScore(Score(300,0), EvenSteven()), expected3000)
    val expected451 = Score(45, 1)
    assertEquals(as.applyScore(Score(45, 1), ScaryFace()), expected451)
  }
}