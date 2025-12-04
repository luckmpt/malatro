package model.jokers

class EvenStevenTest extends munit.FunSuite {

  var evenSteven: EvenSteven = _

  override def beforeEach(context: BeforeEach): Unit = {
    evenSteven = new EvenSteven()
  }

  test("equals") {
    val expected = new EvenSteven()
    assertEquals(expected, evenSteven)
  }

  test("getName") {
    val expected = "Even Steven"
    assertEquals(expected, evenSteven.getName)
  }
}
