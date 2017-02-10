//import OriginalGame._
import Game._

val board = createBoard(5, 5)
val epoch = 4


println("Board")
printBoard(board)
transformBoardOverGenerations(board, 4)