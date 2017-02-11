import Game._

/**
  * Created by Nenyi on 11/02/2017.
  */
object RunGame extends App {
  val boardSize = 5
  val epoch = 5
  val board = createBoard(boardSize, boardSize)
  transformBoardOverGenerations(board, epoch)
}
