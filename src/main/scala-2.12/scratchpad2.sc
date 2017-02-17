import Game._
import scala.util.Random
//board.map(println)
//board.map(b => println(b.mkString(" ")))
//


val x: Int = 9
val y: Int = 9

val board = createBoard(x, y)
//println("getLiveNeighbours")
//val t = getLiveNeighbours(board, 0, 0)
//val t1 = getLiveNeighbours(board, 2, 2)

val xRange = List.range(0, x)
val yRange = List.range(0, y)
//val coords = xRange.map(x => yRange.map(y => (x, y))).flatten
xRange.map(xPoint => yRange.map(yPoint => storeCoordinate(xPoint, yPoint, Random.nextBoolean))).flatten
//coords.length
board.length