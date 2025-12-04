package model.cards.range.figure

import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}
import model.score.Score

class QueenTest extends munit.FunSuite {

  var queen: Queen = _

  override def beforeEach(context: BeforeEach): Unit = {
    queen = new Queen()
  }

  test("equals") {
    val expected = new Queen()
    assertEquals(expected, queen)
  }

  test("getName") {
    val expected = "Queen"
    assertEquals(expected, queen.getName)
  }

  test("getOrder") {
    val expected = 12
    assertEquals(expected, queen.getOrder)
  }

  test("getValue") {
    val expected = 10
    assertEquals(expected, queen.getValue)
  }

  test("getTypeOfRange") {
    val expected = "Figure"
    assertEquals(expected, queen.getTypeOfRange)
  }

  test("applyScore"){
    val expected00 = Score(0, 0)
    assertEquals(queen.applyScore(Score(0,0), DeviousJoker()), expected00)
    val expected305 = Score(30, 5)
    assertEquals(queen.applyScore(Score(30,5), GreedyJoker()), expected305)
    val expected3000 = Score(300, 0)
    assertEquals(queen.applyScore(Score(300,0), EvenSteven()), expected3000)
    val expected451 = Score(45, 1)
    assertEquals(queen.applyScore(Score(45, 1), DeviousJoker()), expected451)
    val expectedEsp1 = Score(30, 0)
    assertEquals(queen.applyScore(Score(0, 0), ScaryFace()), expectedEsp1)
    val expectedEsp2 = Score(50, 4)
    assertEquals(queen.applyScore(Score(20, 4), ScaryFace()), expectedEsp2)
  }
}