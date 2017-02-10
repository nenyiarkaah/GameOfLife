import scala.util.{Random, Try}

/**
  * Created by Nenyi on 09/02/2017.
  */
object OriginalGame {
  type State = Boolean
  type Board = Array[Array[Boolean]]
  val alive = true
  val dead = false

  def createBoard(x: Int, y: Int): Board = {
    Array.fill(y)(Array.fill(x)(Random.nextBoolean))
  }

  def safeGet(state: => State): Option[State] = Try(state).toOption

  def getTopLeft(board: Board, x: Int, y: Int): Option[State] = safeGet {
    board(y - 1)(x - 1)
  }

  def getLeft(board: Board, x: Int, y: Int): Option[State] = safeGet {
    board(y)(x - 1)
  }

  def getBottomLeft(board: Board, x: Int, y: Int): Option[State] = safeGet {
    board(y + 1)(x - 1)
  }

  def getTopRight(board: Board, x: Int, y: Int): Option[State] = safeGet {
    board(y - 1)(x + 1)
  }

  def getRight(board: Board, x: Int, y: Int): Option[State] = safeGet {
    board(y)(x + 1)
  }

  def getBottomRight(board: Board, x: Int, y: Int): Option[State] = safeGet {
    board(y + 1)(x + 1)
  }

  def getTopMiddle(board: Board, x: Int, y: Int): Option[State] = safeGet {
    board(y - 1)(x)
  }

  def getBottomMiddle(board: Board, x: Int, y: Int): Option[State] = safeGet {
    board(y + 1)(x)
  }

  def countLiveNeighbours(board: Board, x: Int, y: Int): Int = {
    List(
      getTopLeft(board, x, y),
      getLeft(board, x, y),
      getBottomLeft(board, x, y),
      getBottomMiddle(board, x, y),
      getBottomRight(board, x, y),
      getRight(board, x, y),
      getTopRight(board, x, y),
      getTopMiddle(board, x, y)
    ).collect {
      case Some(true) => 1
    }.sum
  }

  def transformBoard(theBoard: Board): Board = {
    theBoard.zipWithIndex.map {
      case (innerArray, y) =>
        innerArray.zipWithIndex.map {
          case (cellState, x) =>
            val count = countLiveNeighbours(theBoard, x, y)
            if (cellState) {
              if (count < 2 || count > 3) {
                dead
              } else {
                alive
              }
            } else {
              if (count == 3) alive else dead
            }
        }
    }
  }
}
