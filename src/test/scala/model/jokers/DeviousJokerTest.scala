package model.jokers

class DeviousJokerTest extends munit.FunSuite {

  var deviousJoker: DeviousJoker = _

  override def beforeEach(context: BeforeEach): Unit = {
    deviousJoker = new DeviousJoker()
  }

  test("equals") {
    val expected = new DeviousJoker()
    assertEquals(expected, deviousJoker)
  }

  test("getName") {
    val expected = "Devious Joker"
    assertEquals(expected, deviousJoker.getName)
  }
}
