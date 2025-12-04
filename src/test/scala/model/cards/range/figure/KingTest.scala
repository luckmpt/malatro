package model.cards.range.figure

import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}
import model.score.Score

class KingTest extends munit.FunSuite {

  var king: King = _

  override def beforeEach(context: BeforeEach): Unit = {
    king = new King()
  }

  test("equals") {
    val expected = new King()
    assertEquals(expected, king)
  }

  test("getName") {
    val expected = "King"
    assertEquals(expected, king.getName)
  }

  test("getOrder") {
    val expected = 13
    assertEquals(expected, king.getOrder)
  }

  test("getValue") {
    val expected = 10
    assertEquals(expected, king.getValue)
  }

  test("getTypeOfRange") {
    val expected = "Figure"
    assertEquals(expected, king.getTypeOfRange)
  }

  test("applyScore"){
    val expected00 = Score(0, 0)
    assertEquals(king.applyScore(Score(0,0), DeviousJoker()), expected00)
    val expected305 = Score(30, 5)
    assertEquals(king.applyScore(Score(30,5), GreedyJoker()), expected305)
    val expected3000 = Score(300, 0)
    assertEquals(king.applyScore(Score(300,0), EvenSteven()), expected3000)
    val expected451 = Score(45, 1)
    assertEquals(king.applyScore(Score(45, 1), DeviousJoker()), expected451)
    val expectedEsp1 = Score(30, 0)
    assertEquals(king.applyScore(Score(0, 0), ScaryFace()), expectedEsp1)
    val expectedEsp2 = Score(50, 4)
    assertEquals(king.applyScore(Score(20, 4), ScaryFace()), expectedEsp2)
  }
}