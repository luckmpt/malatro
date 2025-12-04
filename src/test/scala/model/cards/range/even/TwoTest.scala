package model.cards.range.even

import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}
import model.score.Score

class TwoTest extends munit.FunSuite {

  var two: Two = _

  override def beforeEach(context: BeforeEach): Unit = {
    two = new Two()
  }

  test("equals") {
    val expected = new Two()
    assertEquals(expected, two)
  }

  test("getName") {
    val expected = "Two"
    assertEquals(expected, two.getName)
  }

  test("getOrder") {
    val expected = 2
    assertEquals(expected, two.getOrder)
  }

  test("getValue") {
    val expected = 2
    assertEquals(expected, two.getValue)
  }

  test("getTypeOfRange") {
    val expected = "Even"
    assertEquals(expected, two.getTypeOfRange)
  }

  test("applyScore"){
    val expected00 = Score(0, 0)
    assertEquals(two.applyScore(Score(0,0), DeviousJoker()), expected00)
    val expected305 = Score(30, 5)
    assertEquals(two.applyScore(Score(30,5), GreedyJoker()), expected305)
    val expected3000 = Score(300, 0)
    assertEquals(two.applyScore(Score(300,0), DeviousJoker()), expected3000)
    val expected451 = Score(45, 1)
    assertEquals(two.applyScore(Score(45, 1), ScaryFace()), expected451)
    val expectedEsp1 = Score(0, 4)
    assertEquals(two.applyScore(Score(0, 0), EvenSteven()), expectedEsp1)
    val expectedEsp2 = Score(20, 8)
    assertEquals(two.applyScore(Score(20, 4), EvenSteven()), expectedEsp2)
  }
}