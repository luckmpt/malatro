package model.score

class ScoreTest extends munit.FunSuite {

  var tenByTwo: Score = _
  var zeroChip: Score = _
  var zeroMulti: Score = _

  override def beforeEach(context: BeforeEach): Unit = {
    tenByTwo = new Score(10, 2)
    zeroChip = new Score(0, 100)
    zeroMulti = new Score(500, 0)
  }

  test("equals") {
    val expected1 = new Score(10, 2)
    assertEquals(expected1, tenByTwo)
    val expected2 = new Score(0, 100)
    assertEquals(expected2, zeroChip)
    val expected3 = new Score(500, 0)
    assertEquals(expected3, zeroMulti)
  }

  test("getChip") {
    val expected1 = 10
    assertEquals(expected1, tenByTwo.getChip)
    val expected2 = 0
    assertEquals(expected2, zeroChip.getChip)
    val expected3 = 500
    assertEquals(expected3, zeroMulti.getChip)
  }

  test("getMulti") {
    val expected1 = 2
    assertEquals(expected1, tenByTwo.getMulti)
    val expected2 = 100
    assertEquals(expected2, zeroChip.getMulti)
    val expected3 = 0
    assertEquals(expected3, zeroMulti.getMulti)
  }

  test("getScore") {
    val expected1 = 20
    assertEquals(expected1, tenByTwo.getScore)
    val expected2 = 0
    assertEquals(expected2, zeroChip.getScore)
    val expected3 = 0
    assertEquals(expected3, zeroMulti.getScore)
  }
}