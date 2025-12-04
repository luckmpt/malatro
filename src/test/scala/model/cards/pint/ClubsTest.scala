package model.cards.pint

import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}
import model.score.Score

class ClubsTest extends munit.FunSuite {

  var club: Clubs = _

  override def beforeEach(context: BeforeEach): Unit = {
    club = new Clubs()
  }

  test("equals") {
    val expected = new Clubs()
    assertEquals(expected, club)
  }
  
  test("getName") {
    val expected = "Clubs"
    assertEquals(expected, club.getName)
  }
  
  test("applyScore"){
    val expected00 = Score(0, 0)
    assertEquals(club.applyScore(Score(0,0), DeviousJoker()), expected00)
    val expected305 = Score(30, 5)
    assertEquals(club.applyScore(Score(30,5), GreedyJoker()), expected305)
    val expected3000 = Score(300, 0)
    assertEquals(club.applyScore(Score(300,0), EvenSteven()), expected3000)
    val expected451 = Score(45, 1)
    assertEquals(club.applyScore(Score(45, 1), ScaryFace()), expected451)
  }
}
