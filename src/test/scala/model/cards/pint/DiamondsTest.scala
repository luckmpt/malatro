package model.cards.pint

import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}
import model.score.Score

class DiamondsTest extends munit.FunSuite {

  var diamond: Diamonds = _

  override def beforeEach(context: BeforeEach): Unit = {
    diamond = new Diamonds()
  }

  test("equals") {
    val expected = new Diamonds()
    assertEquals(expected, diamond)
  }

  test("getName") {
    val expected = "Diamonds"
    assertEquals(expected, diamond.getName)
  }
  
  test("applyScore"){
    val expected00 = Score(0, 0)
    assertEquals(diamond.applyScore(Score(0,0), DeviousJoker()), expected00)
    val expected305 = Score(30, 5)
    assertEquals(diamond.applyScore(Score(30,5), DeviousJoker()), expected305)
    val expected3000 = Score(300, 0)
    assertEquals(diamond.applyScore(Score(300,0), EvenSteven()), expected3000)
    val expected451 = Score(45, 1)
    assertEquals(diamond.applyScore(Score(45, 1), ScaryFace()), expected451)
    val expectedEsp1 = Score(0, 3)
    assertEquals(diamond.applyScore(Score(0, 0), GreedyJoker()), expectedEsp1)
    val expectedEsp2 = Score(20, 7)
    assertEquals(diamond.applyScore(Score(20, 4), GreedyJoker()), expectedEsp2)
  }
}
