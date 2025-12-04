package model.cards.range.even

import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}
import model.score.Score

class EightTest extends munit.FunSuite {

  var eight: Eight = _

  override def beforeEach(context: BeforeEach): Unit = {
    eight = new Eight()
  }

  test("equals") {
    val expected = new Eight()
    assertEquals(expected, eight)
  }

  test("getName") {
    val expected = "Eight"
    assertEquals(expected, eight.getName)
  }

  test("getOrder") {
    val expected = 8
    assertEquals(expected, eight.getOrder)
  }

  test("getValue") {
    val expected = 8
    assertEquals(expected, eight.getValue)
  }

  test("getTypeOfRange") {
    val expected = "Even"
    assertEquals(expected, eight.getTypeOfRange)
  }

  test("applyScore"){
    val expected00 = Score(0, 0)
    assertEquals(eight.applyScore(Score(0,0), DeviousJoker()), expected00)
    val expected305 = Score(30, 5)
    assertEquals(eight.applyScore(Score(30,5), GreedyJoker()), expected305)
    val expected3000 = Score(300, 0)
    assertEquals(eight.applyScore(Score(300,0), DeviousJoker()), expected3000)
    val expected451 = Score(45, 1)
    assertEquals(eight.applyScore(Score(45, 1), ScaryFace()), expected451)
    val expectedEsp1 = Score(0, 4)
    assertEquals(eight.applyScore(Score(0, 0), EvenSteven()), expectedEsp1)
    val expectedEsp2 = Score(20, 8)
    assertEquals(eight.applyScore(Score(20, 4), EvenSteven()), expectedEsp2)
  }
}
