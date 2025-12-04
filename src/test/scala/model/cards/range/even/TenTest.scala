package model.cards.range.even

import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}
import model.score.Score

class TenTest extends munit.FunSuite {

  var ten: Ten = _

  override def beforeEach(context: BeforeEach): Unit = {
    ten = new Ten()
  }

  test("equals") {
    val expected = new Ten()
    assertEquals(expected, ten)
  }

  test("getName") {
    val expected = "Ten"
    assertEquals(expected, ten.getName)
  }

  test("getOrder") {
    val expected = 10
    assertEquals(expected, ten.getOrder)
  }

  test("getValue") {
    val expected = 10
    assertEquals(expected, ten.getValue)
  }

  test("getTypeOfRange") {
    val expected = "Even"
    assertEquals(expected, ten.getTypeOfRange)
  }

  test("applyScore"){
    val expected00 = Score(0, 0)
    assertEquals(ten.applyScore(Score(0,0), DeviousJoker()), expected00)
    val expected305 = Score(30, 5)
    assertEquals(ten.applyScore(Score(30,5), GreedyJoker()), expected305)
    val expected3000 = Score(300, 0)
    assertEquals(ten.applyScore(Score(300,0), DeviousJoker()), expected3000)
    val expected451 = Score(45, 1)
    assertEquals(ten.applyScore(Score(45, 1), ScaryFace()), expected451)
    val expectedEsp1 = Score(0, 4)
    assertEquals(ten.applyScore(Score(0, 0), EvenSteven()), expectedEsp1)
    val expectedEsp2 = Score(20, 8)
    assertEquals(ten.applyScore(Score(20, 4), EvenSteven()), expectedEsp2)
  }
}
