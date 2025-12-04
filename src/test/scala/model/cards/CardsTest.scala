package model.cards
import model.cards.range.even.Four
import model.cards.pint.{Diamonds, Hearts, Spades}
import model.cards.range.figure.King
import model.cards.range.odd.Three
import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}
import model.score.Score

class CardsTest extends munit.FunSuite {

  var fourOfSpades: Cards = _
  var kingOfHearts: Cards = _
  var threeOfDiamonds: Cards = _

  override def beforeEach(context: BeforeEach): Unit = {
    fourOfSpades = new Cards(Four(), Spades())
    kingOfHearts = new Cards(King(), Hearts())
    threeOfDiamonds = new Cards(Three(), Diamonds())
  }

  test("equals") {
    val expected1 = new Cards(Four(), Spades())
    assertEquals(expected1, fourOfSpades)
    val expected2 = new Cards(King(), Hearts())
    assertEquals(expected2, kingOfHearts)
  }
  
  test("getRange") {
    val expected1 = new Four()
    assertEquals(fourOfSpades.getRange, expected1)
    val expected2 = new King()
    assertEquals(kingOfHearts.getRange, expected2)
    val expected3 = new Three()
    assertEquals(threeOfDiamonds.getRange, expected3)
  }

  test("getPint") {
    val expected1 = new Spades()
    assertEquals(fourOfSpades.getPint, expected1)
    val expected2 = new Hearts()
    assertEquals(kingOfHearts.getPint, expected2)
    val expected3 = new Diamonds()
    assertEquals(threeOfDiamonds.getPint, expected3)
  }
  
  test("ApplyScore"){
    val expectedFS2 = new Score(4, 4)
    assertEquals(
      fourOfSpades.applyScore(Score(0, 0), List(EvenSteven())),
      expectedFS2
    )
    val expectedFS3 = new Score(14, 6)
    assertEquals(
      fourOfSpades.applyScore(Score(10, 2), List(
        DeviousJoker(),
        EvenSteven(),
        GreedyJoker(),
        ScaryFace()
      )),
      expectedFS3
    )
    val expectedKH2 = new Score(40, 0)
    assertEquals(
      kingOfHearts.applyScore(Score(0, 0), List(ScaryFace())),
      expectedKH2
    )
    val expectedKH3 = new Score(50, 2)
    assertEquals(
      kingOfHearts.applyScore(Score(10, 2), List(
        DeviousJoker(),
        EvenSteven(),
        GreedyJoker(),
        ScaryFace()
      )),
      expectedKH3
    )
    val expectedTD2 = new Score(3, 3)
    assertEquals(
      threeOfDiamonds.applyScore(Score(0, 0), List(GreedyJoker())),
      expectedTD2
    )
    val expectedTD3 = new Score(13, 5)
    assertEquals(
      threeOfDiamonds.applyScore(Score(10, 2), List(
        DeviousJoker(),
        EvenSteven(),
        GreedyJoker(),
        ScaryFace()
      )),
      expectedTD3
    )
  }
}