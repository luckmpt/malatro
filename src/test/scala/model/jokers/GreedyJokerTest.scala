package model.jokers

class GreedyJokerTest extends munit.FunSuite {

  var GreedyJoker: GreedyJoker = _

  override def beforeEach(context: BeforeEach): Unit = {
    GreedyJoker = new GreedyJoker()
  }

  test("equals") {
    val expected = new GreedyJoker()
    assertEquals(expected, GreedyJoker)
  }

  test("getName") {
    val expected = "Greedy Joker"
    assertEquals(expected, GreedyJoker.getName)
  }
}

