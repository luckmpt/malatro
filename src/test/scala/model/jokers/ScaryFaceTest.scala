package model.jokers

class ScaryFaceTest extends munit.FunSuite {

  var scaryFace: ScaryFace = _

  override def beforeEach(context: BeforeEach): Unit = {
    scaryFace = new ScaryFace()
  }

  test("equals") {
    val expected = new ScaryFace()
    assertEquals(expected, scaryFace)
  }

  test("getName") {
    val expected = "Scary Face"
    assertEquals(expected, scaryFace.getName)
  }
}
