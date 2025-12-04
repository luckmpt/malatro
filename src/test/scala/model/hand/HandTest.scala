package model.hand

import model.cards.Cards
import model.cards.pint.{Clubs, Diamonds, Hearts, Spades}
import model.cards.range.even.{Eight, Four, Six, Ten, Two}
import model.cards.range.figure.{Jota, King, Queen}
import model.cards.range.odd.{As, Five, Nine, Seven, Three}
import model.jokers.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace}
import model.score.{IScore, Score}

class HandTest extends munit.FunSuite {

  var emptyHand: Hand = _
  var fullHand: Hand = _

  override def beforeEach(context: BeforeEach): Unit = {
    emptyHand = new Hand(List(), List())
    fullHand = new Hand(
      List(
        Cards(Seven(), Spades()),
        Cards(As(), Diamonds()),
        Cards(Jota(), Clubs()),
        Cards(Four(), Spades()),
        Cards(King(), Clubs()),
        Cards(Five(), Hearts()),
        Cards(Ten(), Diamonds()),
        Cards(Queen(), Hearts())
      ),
      List(
        DeviousJoker(),
        ScaryFace()
      )
    )
  }

  test("equals") {
    val expected1 = new Hand(List(), List())
    assertEquals(expected1, emptyHand)
    val expected2 = new Hand(
      List(
        Cards(Seven(), Spades()),
        Cards(As(), Diamonds()),
        Cards(Jota(), Clubs()),
        Cards(Four(), Spades()),
        Cards(King(), Clubs()),
        Cards(Five(), Hearts()),
        Cards(Ten(), Diamonds()),
        Cards(Queen(), Hearts())
      ),
      List(
        DeviousJoker(),
        ScaryFace()
      )
    )
    assertEquals(expected2, fullHand)
  }

  test("getCards") {
    val expected1 = List()
    assertEquals(emptyHand.getCards, expected1)
    val expected2 = List(
      Cards(Seven(), Spades()),
      Cards(As(), Diamonds()),
      Cards(Jota(), Clubs()),
      Cards(Four(), Spades()),
      Cards(King(), Clubs()),
      Cards(Five(), Hearts()),
      Cards(Ten(), Diamonds()),
      Cards(Queen(), Hearts())
    )
    assertEquals(fullHand.getCards, expected2)
  }

  test("getJokers") {
    val expected1 = List()
    assertEquals(emptyHand.getJokers, expected1)
    val expected2 = List(
      DeviousJoker(),
      ScaryFace()
    )
    assertEquals(fullHand.getJokers, expected2)
  }

  test("addCards") {
    val expected = Hand(
      List(
        Cards(Nine(), Diamonds()),
        Cards(Two(), Diamonds()),
        Cards(King(), Spades()),
        Cards(As(), Spades()),
        Cards(Six(), Diamonds()),
        Cards(Three(), Clubs()),
        Cards(Eight(), Spades()),
        Cards(Queen(), Hearts()),
      ),
      List()
    )
    emptyHand.addCard(Cards(Nine(), Diamonds()))
    emptyHand.addCard(Cards(Two(), Diamonds()))
    emptyHand.addCard(Cards(King(), Spades()))
    emptyHand.addCard(Cards(As(), Spades()))
    emptyHand.addCard(Cards(Six(), Diamonds()))
    emptyHand.addCard(Cards(Three(), Clubs()))
    emptyHand.addCard(Cards(Eight(), Spades()))
    emptyHand.addCard(Cards(Queen(), Hearts()))
    assertEquals(emptyHand, expected)
  }

  test("addJoker"){
    val expected = Hand(
      List(),
      List(
        EvenSteven(),
        GreedyJoker()
      )
    )
    emptyHand.addJoker(EvenSteven())
    emptyHand.addJoker(GreedyJoker())
    assertEquals(emptyHand, expected)
  }

  test("removeCards"){
    val expected = Hand(
      List(
        Cards(Seven(), Spades()),
        Cards(Jota(), Clubs()),
        Cards(Ten(), Diamonds()),
      ),
      List(
        DeviousJoker(),
        ScaryFace()
      )
    )
    fullHand.removeCard(4)
    fullHand.removeCard(1)
    fullHand.removeCard(5)
    fullHand.removeCard(2)
    fullHand.removeCard(2)
    // Note that when you remove one,
    // the indexes of the following ones decrease by one.
    assertEquals(fullHand, expected)
  }

  test("removeJoker"){
    val expected = Hand(
      List(
        Cards(Seven(), Spades()),
        Cards(As(), Diamonds()),
        Cards(Jota(), Clubs()),
        Cards(Four(), Spades()),
        Cards(King(), Clubs()),
        Cards(Five(), Hearts()),
        Cards(Ten(), Diamonds()),
        Cards(Queen(), Hearts())
      ),
      List(
        ScaryFace()
      )
    )
    fullHand.removeJoker(0)
    assertEquals(fullHand, expected)
  }

  test("play") {
    val expectedHand = Hand(
      List(
        Cards(Seven(), Spades()),
        Cards(Four(), Spades()),
        Cards(Five(), Hearts()),
      ),
      List(
        DeviousJoker(),
        ScaryFace()
      )
    )
    val expectedList = List(
      Cards(Ten(), Diamonds()),
      Cards(Jota(), Clubs()),
      Cards(Queen(), Hearts()),
      Cards(King(), Clubs()),
      Cards(As(), Diamonds()),
    )
    assertEquals(fullHand.play(List(6, 2, 7, 4, 1)),expectedList)
    assertEquals(fullHand, expectedHand)
  }

  test("applyScore"){
    val expected: IScore = Score(261, 4)
    val handPlayed: IHand = Hand(
      fullHand.play(List(6,2,7,4,1)),
      fullHand.getJokers
    )
    assertEquals(handPlayed.applyScore, expected)

  }
}

