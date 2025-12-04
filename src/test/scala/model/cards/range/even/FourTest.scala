package model.cards.range.even

import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}
import model.score.Score

class FourTest extends munit.FunSuite {

  var four: Four = _

  override def beforeEach(context: BeforeEach): Unit = {
    four = new Four()
  }

  test("equals") {
    val expected = new Four()
    assertEquals(expected, four)
  }

  test("getName") {
    val expected = "Four"
    assertEquals(expected, four.getName)
  }

  test("getOrder") {
    val expected = 4
    assertEquals(expected, four.getOrder)
  }

  test("getValue") {
    val expected = 4
    assertEquals(expected, four.getValue)
  }

  test("getTypeOfRange") {
    val expected = "Even"
    assertEquals(expected, four.getTypeOfRange)
  }

  test("applyScore"){
    val expected00 = Score(0, 0)
    assertEquals(four.applyScore(Score(0,0), DeviousJoker()), expected00)
    val expected305 = Score(30, 5)
    assertEquals(four.applyScore(Score(30,5), GreedyJoker()), expected305)
    val expected3000 = Score(300, 0)
    assertEquals(four.applyScore(Score(300,0), DeviousJoker()), expected3000)
    val expected451 = Score(45, 1)
    assertEquals(four.applyScore(Score(45, 1), ScaryFace()), expected451)
    val expectedEsp1 = Score(0, 4)
    assertEquals(four.applyScore(Score(0, 0), EvenSteven()), expectedEsp1)
    val expectedEsp2 = Score(20, 8)
    assertEquals(four.applyScore(Score(20, 4), EvenSteven()), expectedEsp2)
  }
}