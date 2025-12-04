package model.cards.pint

import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}
import model.score.Score

class HeartsTest extends munit.FunSuite {

  var heart: Hearts = _

  override def beforeEach(context: BeforeEach): Unit = {
    heart = new Hearts()
  }

  test("equals") {
    val expected = new Hearts()
    assertEquals(expected, heart)
  }

  test("getName") {
    val expected = "Hearts"
    assertEquals(expected, heart.getName)
  }
  
  test("applyScore"){
    val expected00 = Score(0, 0)
    assertEquals(heart.applyScore(Score(0,0), DeviousJoker()), expected00)
    val expected305 = Score(30, 5)
    assertEquals(heart.applyScore(Score(30,5), GreedyJoker()), expected305)
    val expected3000 = Score(300, 0)
    assertEquals(heart.applyScore(Score(300,0), EvenSteven()), expected3000)
    val expected451 = Score(45, 1)
    assertEquals(heart.applyScore(Score(45, 1), ScaryFace()), expected451)
  }
}

