import scala.collection.mutable.ListBuffer
import scala.util.Random

/**
  * Created by Nenyi on 10/02/2017.
  */
object Game {
  type State = Boolean
  type Board = List[Coordinates]
  val alive = true
  val dead = false

  case class Coordinates(x: Int, y: Int, state: State)

  def max(a: Coordinates, b: Coordinates): Coordinates = if ((a.x > b.x) & (a.y > b.y)) a else b

  def createBoard(x: Int, y: Int): Board = {
    var board = new ListBuffer[Coordinates]
    for {
      xPoint <- 0 until x
      yPoint <- 0 until y
    } {
      board += storeCoordinate(xPoint, yPoint, Random.nextBoolean)
    }
    board.toList
  }

  def getNeighbours(board: Board, x: Int, y: Int) = {

    val radius = 1
    val maxCoordinates = board.reduceLeft(max)
    val xMin = clamp(x - radius, 0, maxCoordinates.x)
    val xMax = clamp(x + radius, 0, maxCoordinates.x) + 1
    val yMin = clamp(y - radius, 0, maxCoordinates.y)
    val yMax = clamp(y + radius, 0, maxCoordinates.y) + 1
    var neighbours = ListBuffer[Coordinates]()

    for {
      xPoint <- xMin until xMax
      yPoint <- yMin until yMax
    } {
      if (!(xPoint == x & yPoint == y)) {
        val state = board.filter(b => (b.x == xPoint) & (b.y == yPoint)).headOption.get.state
        neighbours += storeCoordinate(xPoint, yPoint, state)
      }
    }
    neighbours.toList
  }

  def getLiveNeighbours(board: Board, x: Int, y: Int) = {
    getNeighbours(board, x, y).filter(n => n.state == alive).length
  }

  def storeCoordinate(x: Int, y: Int, state: State) = {
    new Coordinates(x, y, state)
  }

  def clamp(v: Int, min: Int, max: Int) = {
    if (v < min) min
    else if (v > max) max
    else v
  }

  def transformCoordinates(coordinates: Coordinates, liveNeighbours: Int) = {
    val state = coordinates.state match {
      case `alive` => liveNeighbours match {
        case s if s < 2 => dead
        case s if s >= 2 & s <= 3 => alive
        case s if s > 3 => dead
      }
      case `dead` => liveNeighbours match {
        case s if s == 3 => alive
        case _ => dead
      }
    }
    storeCoordinate(coordinates.x, coordinates.y, state)
  }

  def transformBoard(board: Board): Board = {
    board.map(b => transformCoordinates(b, getLiveNeighbours(board, b.x, b.y)))
  }

  def printBoard(board: Board) = {
    val maxCoordinates = board.reduceLeft(max)
    val xMin = 0
    val xMax = maxCoordinates.x + 1
    val yMin = 0
    val yMax = maxCoordinates.y + 1
    for {y <- yMin until yMax} {
      for {x <- xMin until xMax} {
        val state = board.filter(b => (b.x == x) & (b.y == y)).headOption.get.state
        print(if (state) "alive " else "dead ")
      }
      println("")
    }
  }

  def transformBoardOverGenerations(board: Board, epoch: Int) = {
    var epochBoard = board
    for {i <- 0 until epoch} {
      epochBoard = transformBoard(epochBoard)
      println("epoch " + i)
      printBoard(epochBoard)
    }
  }

}
