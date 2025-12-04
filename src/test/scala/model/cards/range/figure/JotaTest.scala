package model.cards.range.figure

import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}
import model.score.Score

class JotaTest extends munit.FunSuite {

  var jota: Jota = _

  override def beforeEach(context: BeforeEach): Unit = {
    jota = new Jota()
  }

  test("equals") {
    val expected = new Jota()
    assertEquals(expected, jota)
  }

  test("getName") {
    val expected = "Jota"
    assertEquals(expected, jota.getName)
  }

  test("getOrder") {
    val expected = 11
    assertEquals(expected, jota.getOrder)
  }

  test("getValue") {
    val expected = 10
    assertEquals(expected, jota.getValue)
  }

  test("getTypeOfRange") {
    val expected = "Figure"
    assertEquals(expected, jota.getTypeOfRange)
  }

  test("applyScore"){
    val expected00 = Score(0, 0)
    assertEquals(jota.applyScore(Score(0,0), DeviousJoker()), expected00)
    val expected305 = Score(30, 5)
    assertEquals(jota.applyScore(Score(30,5), GreedyJoker()), expected305)
    val expected3000 = Score(300, 0)
    assertEquals(jota.applyScore(Score(300,0), EvenSteven()), expected3000)
    val expected451 = Score(45, 1)
    assertEquals(jota.applyScore(Score(45, 1), DeviousJoker()), expected451)
    val expectedEsp1 = Score(30, 0)
    assertEquals(jota.applyScore(Score(0, 0), ScaryFace()), expectedEsp1)
    val expectedEsp2 = Score(50, 4)
    assertEquals(jota.applyScore(Score(20, 4), ScaryFace()), expectedEsp2)
  }
}