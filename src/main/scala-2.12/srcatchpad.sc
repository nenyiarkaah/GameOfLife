//import OriginalGame._
import Game._

import scala.collection.mutable.ListBuffer
import scala.util.Random

//val board = createBoard(5, 5)
//val epoch = 4
//
//val x = 0
//val y = 0
//val radius = 1
//val maxCoordinates = board.reduceLeft(max)
//val xMin = clamp(x - radius, 0, maxCoordinates.x)
//val xMax = clamp(x + radius, 0, maxCoordinates.x) + 1
//val yMin = clamp(y - radius, 0, maxCoordinates.y)
//val yMax = clamp(y + radius, 0, maxCoordinates.y) + 1
//
//val xRange =  List.range(xMin, xMax)
//val yRange = List.range(yMin, yMax)
//
//def prod[T](lst: List[T], n: Int) = List.fill(n)(lst)
//  .flatten.combinations(n).flatMap(_.permutations)
//val neighbourcoords = prod(yRange, xRange.size)
//  .map(xRange.zip(_)).toList.flatten.distinct
//  .filter(_ != (x,y))
//
//val neighbours = neighbourcoords.map(n =>
//  board.filter(b => (b.x == n._1) & (b.y == n._2)).headOption.get)
val x: Int = 8
val y: Int = 8
val xRange = List.range(0, x)
val yRange = List.range(0, y)

//def prod[T](lst: List[T], n: Int) = List.fill(n)(lst)
//  .flatten.combinations(n).flatMap(_.permutations)
//
//val coords = prod(yRange, xRange.size).map(xRange.zip(_))
//  .toList.flatten
//
//coords.length
//coords.distinct.length
//val board = coords.map(c => storeCoordinate(c._1, c._2, Random.nextBoolean))

//for {
//  xPoint <- 0 until x
//  yPoint <- 0 until y
//} {
//  board += storeCoordinate(xPoint, yPoint, Random.nextBoolean)
//}
//board.toList