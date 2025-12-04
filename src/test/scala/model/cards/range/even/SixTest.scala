package model.cards.range.even

import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}
import model.score.Score

class SixTest extends munit.FunSuite {

  var six: Six = _

  override def beforeEach(context: BeforeEach): Unit = {
    six = new Six()
  }

  test("equals") {
    val expected = new Six()
    assertEquals(expected, six)
  }

  test("getName") {
    val expected = "Six"
    assertEquals(expected, six.getName)
  }

  test("getOrder") {
    val expected = 6
    assertEquals(expected, six.getOrder)
  }

  test("getValue") {
    val expected = 6
    assertEquals(expected, six.getValue)
  }

  test("getTypeOfRange") {
    val expected = "Even"
    assertEquals(expected, six.getTypeOfRange)
  }

  test("applyScore"){
    val expected00 = Score(0, 0)
    assertEquals(six.applyScore(Score(0,0), DeviousJoker()), expected00)
    val expected305 = Score(30, 5)
    assertEquals(six.applyScore(Score(30,5), GreedyJoker()), expected305)
    val expected3000 = Score(300, 0)
    assertEquals(six.applyScore(Score(300,0), DeviousJoker()), expected3000)
    val expected451 = Score(45, 1)
    assertEquals(six.applyScore(Score(45, 1), ScaryFace()), expected451)
    val expectedEsp1 = Score(0, 4)
    assertEquals(six.applyScore(Score(0, 0), EvenSteven()), expectedEsp1)
    val expectedEsp2 = Score(20, 8)
    assertEquals(six.applyScore(Score(20, 4), EvenSteven()), expectedEsp2)
  }
}