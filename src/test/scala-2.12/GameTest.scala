import org.scalatest.{FlatSpec, FunSuite}
import org.scalatest.Matchers._
import org.scalatest.BeforeAndAfter
import Game._

/**
  * Created by Nenyi on 10/02/2017.
  */
class GameTest extends FlatSpec with BeforeAndAfter {
  var board: Board = List(Coordinates(0, 0, false), Coordinates(0, 1, true), Coordinates(0, 2, true), Coordinates(0, 3, true),
    Coordinates(0, 4, false), Coordinates(1, 0, false), Coordinates(1, 1, false), Coordinates(1, 2, true),
    Coordinates(1, 3, false), Coordinates(1, 4, false), Coordinates(2, 0, true), Coordinates(2, 1, false),
    Coordinates(2, 2, false), Coordinates(2, 3, true), Coordinates(2, 4, true), Coordinates(3, 0, false), Coordinates(3, 1, false),
    Coordinates(3, 2, true), Coordinates(3, 3, true), Coordinates(3, 4, true), Coordinates(4, 0, true), Coordinates(4, 1, true),
    Coordinates(4, 2, false), Coordinates(4, 3, true), Coordinates(4, 4, true))

  "createBoard" should "create a list of 25 coordinates for a 5 x 5 board" in {
    createBoard(5, 5).length shouldBe 25
  }
  it should "create a list of 64 coordinates for a 8 x 8 board" in {
    createBoard(8, 8).length shouldBe 64
  }

  "getNeighbours" should "return 3 neighbours for Top Left (0,0)" in {
    getNeighbours(board, 0, 0).length shouldBe 3
  }
  it should "return 5 neighbours for (0,1)" in {
    getNeighbours(board, 0, 1).length shouldBe 5
  }
  it should "return 5 neighbours for Top Middle (0,2)" in {
    getNeighbours(board, 0, 2).length shouldBe 5
  }
  it should "return 5 neighbours for (0,3)" in {
    getNeighbours(board, 0, 3).length shouldBe 5
  }
  it should "return 3 neighbours for Top Right (0,4)" in {
    getNeighbours(board, 0, 4).length shouldBe 3
  }
  it should "return 5 neighbours for Left (1,0)" in {
    getNeighbours(board, 1, 0).length shouldBe 5
  }
  it should "return 8 neighbours for (1,1)" in {
    getNeighbours(board, 1, 1).length shouldBe 8
  }
  it should "return 8 neighbours for Middle (1,2)" in {
    getNeighbours(board, 1, 2).length shouldBe 8
  }
  it should "return 8 neighbours for (1,3)" in {
    getNeighbours(board, 1, 3).length shouldBe 8
  }
  it should "return 5 neighbours for Top Right (1,4)" in {
    getNeighbours(board, 1, 4).length shouldBe 5
  }
  it should "return 5 neighbours for Middle Left (2,0)" in {
    getNeighbours(board, 2, 0).length shouldBe 5
  }
  it should "return 8 neighbours for (2,1)" in {
    getNeighbours(board, 2, 1).length shouldBe 8
  }
  it should "return 8 neighbours for Middle (2,2)" in {
    getNeighbours(board, 2, 2).length shouldBe 8
  }
  it should "return 8 neighbours for (2,3)" in {
    getNeighbours(board, 2, 3).length shouldBe 8
  }
  it should "return 5 neighbours for Middle Right (2,4)" in {
    getNeighbours(board, 2, 4).length shouldBe 5
  }
  it should "return 5 neighbours for (3,0)" in {
    getNeighbours(board, 3, 0).length shouldBe 5
  }
  it should "return 8 neighbours for (3,1)" in {
    getNeighbours(board, 3, 1).length shouldBe 8
  }
  it should "return 8 neighbours for (3,2)" in {
    getNeighbours(board, 3, 2).length shouldBe 8
  }
  it should "return 8 neighbours for (3,3)" in {
    getNeighbours(board, 3, 3).length shouldBe 8
  }
  it should "return 5 neighbours for (3,4)" in {
    getNeighbours(board, 3, 4).length shouldBe 5
  }
  it should "return 3 neighbours for Bottom Left (4,0)" in {
    getNeighbours(board, 4, 0).length shouldBe 3
  }
  it should "return 5 neighbours for (4,1)" in {
    getNeighbours(board, 4, 1).length shouldBe 5
  }
  it should "return 5 neighbours for Top Middle (4,2)" in {
    getNeighbours(board, 4, 2).length shouldBe 5
  }
  it should "return 5 neighbours for (4,3)" in {
    getNeighbours(board, 4, 3).length shouldBe 5
  }
  it should "return 3 neighbours for Bottom Right (4,4)" in {
    getNeighbours(board, 4, 4).length shouldBe 3
  }

  "getLiveNeighbours" should "return 1 live neighbours for Top Left (0,0)" in {
    getLiveNeighbours(board, 0, 0) shouldBe 1
  }
  it should "return 2 live neighbours for (0,1)" in {
    getLiveNeighbours(board, 0, 1) shouldBe 2
  }
  it should "return 3 live neighbours for Top Middle (0,2)" in {
    getLiveNeighbours(board, 0, 2) shouldBe 3
  }
  it should "return 2 live neighbours for (0,3)" in {
    getLiveNeighbours(board, 0, 3) shouldBe 2
  }
  it should "return 1 live neighbours for Top Right (0,4)" in {
    getLiveNeighbours(board, 0, 4) shouldBe 1
  }
  it should "return 2 live neighbours for Left (1,0)" in {
    getLiveNeighbours(board, 1, 0) shouldBe 2
  }
  it should "return 4 live neighbours for (1,1)" in {
    getLiveNeighbours(board, 1, 1) shouldBe 4
  }
  it should "return 4 live neighbours for Middle (1,2)" in {
    getLiveNeighbours(board, 1, 2) shouldBe 4
  }
  it should "return 5 live neighbours for (1,3)" in {
    getLiveNeighbours(board, 1, 3) shouldBe 5
  }
  it should "return 3 live neighbours for Top Right (1,4)" in {
    getLiveNeighbours(board, 1, 4) shouldBe 3
  }
  it should "return 0 live neighbours for Middle Left (2,0)" in {
    getLiveNeighbours(board, 2, 0) shouldBe 0
  }
  it should "return 3 live neighbours for (2,1)" in {
    getLiveNeighbours(board, 2, 1) shouldBe 3
  }
  it should "return 4 live neighbours for Middle (2,2)" in {
    getLiveNeighbours(board, 2, 2) shouldBe 4
  }
  it should "return 5 live neighbours for (2,3)" in {
    getLiveNeighbours(board, 2, 3) shouldBe 5
  }
  it should "return 3 live neighbours for Middle Right (2,4)" in {
    getLiveNeighbours(board, 2, 4) shouldBe 3
  }
  it should "return 3 live neighbours for (3,0)" in {
    getLiveNeighbours(board, 3, 0) shouldBe 3
  }
  it should "return 4 live neighbours for (3,1)" in {
    getLiveNeighbours(board, 3, 1) shouldBe 4
  }
  it should "return 4 live neighbours for (3,2)" in {
    getLiveNeighbours(board, 3, 2) shouldBe 4
  }
  it should "return 6 live neighbours for (3,3)" in {
    getLiveNeighbours(board, 3, 3) shouldBe 6
  }
  it should "return 5 live neighbours for (3,4)" in {
    getLiveNeighbours(board, 3, 4) shouldBe 5
  }
  it should "return 1 live neighbours for Bottom Left (4,0)" in {
    getLiveNeighbours(board, 4, 0) shouldBe 1
  }
  it should "return 2 live neighbours for (4,1)" in {
    getLiveNeighbours(board, 4, 1) shouldBe 2
  }
  it should "return 4 live neighbours for Top Middle (4,2)" in {
    getLiveNeighbours(board, 4, 2) shouldBe 4
  }
  it should "return 4 live neighbours for (4,3)" in {
    getLiveNeighbours(board, 4, 3) shouldBe 4
  }
  it should "return 3 live neighbours for Bottom Right (4,4)" in {
    getLiveNeighbours(board, 4, 4) shouldBe 3
  }

  "transformCoordinates" should "handle basic tests" in {
    transformCoordinates(new Coordinates(0, 0, dead), getLiveNeighbours(board, 0, 0)) shouldBe new Coordinates(0, 0, dead)

    transformCoordinates(new Coordinates(0, 4, dead), getLiveNeighbours(board, 0, 4)) shouldBe new Coordinates(0, 4, dead)

    transformCoordinates(new Coordinates(3, 0, dead), getLiveNeighbours(board, 3, 0)) shouldBe new Coordinates(3, 0, alive)
  }
}
