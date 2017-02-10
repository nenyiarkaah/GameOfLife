import org.scalatest.{FreeSpec, Matchers}
import OriginalGame._

/**
  * Created by Nenyi on 10/02/2017.
  */
class OriginalGameTest extends FreeSpec with Matchers {

  val board1 = Array(
    Array(alive, dead),
    Array(dead, dead)
  )

  val board2 = Array(
    Array(dead, alive, dead),
    Array(alive, dead, dead),
    Array(alive, alive, dead)
  )

  "Getting neighbours at position" - {
    "top left" in {
      getTopLeft(board1, 0, 0) shouldBe None
      getTopLeft(board1, 0, 1) shouldBe None
      getTopLeft(board1, 1, 0) shouldBe None
      getTopLeft(board1, 1, 1) shouldBe Some(alive)

      getTopLeft(board2, 0, 0) shouldBe None
      getTopLeft(board2, 0, 1) shouldBe None
      getTopLeft(board2, 0, 2) shouldBe None
      getTopLeft(board2, 1, 0) shouldBe None
      getTopLeft(board2, 1, 1) shouldBe Some(dead)
      getTopLeft(board2, 1, 2) shouldBe Some(alive)
      getTopLeft(board2, 2, 0) shouldBe None
      getTopLeft(board2, 2, 1) shouldBe Some(alive)
      getTopLeft(board2, 2, 2) shouldBe Some(dead)
    }
    "left" in {
      getLeft(board1, 0, 0) shouldBe None
      getLeft(board1, 0, 1) shouldBe None
      getLeft(board1, 1, 0) shouldBe Some(alive)
      getLeft(board1, 1, 1) shouldBe Some(dead)

      getLeft(board2, 0, 0) shouldBe None
      getLeft(board2, 0, 1) shouldBe None
      getLeft(board2, 0, 2) shouldBe None
      getLeft(board2, 1, 0) shouldBe Some(dead)
      getLeft(board2, 1, 1) shouldBe Some(alive)
      getLeft(board2, 1, 2) shouldBe Some(alive)
      getLeft(board2, 2, 0) shouldBe Some(alive)
      getLeft(board2, 2, 1) shouldBe Some(dead)
      getLeft(board2, 2, 2) shouldBe Some(alive)
    }
    "bottom left" in {
      getBottomLeft(board1, 0, 0) shouldBe None
      getBottomLeft(board1, 0, 1) shouldBe None
      getBottomLeft(board1, 1, 0) shouldBe Some(dead)
      getBottomLeft(board1, 1, 1) shouldBe None

      getBottomLeft(board2, 0, 0) shouldBe None
      getBottomLeft(board2, 0, 1) shouldBe None
      getBottomLeft(board2, 0, 2) shouldBe None
      getBottomLeft(board2, 1, 0) shouldBe Some(alive)
      getBottomLeft(board2, 1, 1) shouldBe Some(alive)
      getBottomLeft(board2, 1, 2) shouldBe None
      getBottomLeft(board2, 2, 0) shouldBe Some(dead)
      getBottomLeft(board2, 2, 1) shouldBe Some(alive)
      getBottomLeft(board2, 2, 2) shouldBe None
    }
    "bottom middle" in {
      getBottomMiddle(board1, 0, 0) shouldBe Some(dead)
      getBottomMiddle(board1, 0, 1) shouldBe None
      getBottomMiddle(board1, 1, 0) shouldBe Some(dead)
      getBottomMiddle(board1, 1, 1) shouldBe None

      getBottomMiddle(board2, 0, 0) shouldBe Some(alive)
      getBottomMiddle(board2, 0, 1) shouldBe Some(alive)
      getBottomMiddle(board2, 0, 2) shouldBe None
      getBottomMiddle(board2, 1, 0) shouldBe Some(dead)
      getBottomMiddle(board2, 1, 1) shouldBe Some(alive)
      getBottomMiddle(board2, 1, 2) shouldBe None
      getBottomMiddle(board2, 2, 0) shouldBe Some(dead)
      getBottomMiddle(board2, 2, 1) shouldBe Some(dead)
      getBottomMiddle(board2, 2, 2) shouldBe None
    }
    "bottom right" in {
      getBottomRight(board1, 0, 0) shouldBe Some(dead)
      getBottomRight(board1, 0, 1) shouldBe None
      getBottomRight(board1, 1, 0) shouldBe None
      getBottomRight(board1, 1, 1) shouldBe None

      getBottomRight(board2, 0, 0) shouldBe Some(dead)
      getBottomRight(board2, 0, 1) shouldBe Some(alive)
      getBottomRight(board2, 0, 2) shouldBe None
      getBottomRight(board2, 1, 0) shouldBe Some(dead)
      getBottomRight(board2, 1, 1) shouldBe Some(dead)
      getBottomRight(board2, 1, 2) shouldBe None
      getBottomRight(board2, 2, 0) shouldBe None
      getBottomRight(board2, 2, 1) shouldBe None
      getBottomRight(board2, 2, 2) shouldBe None
    }
    "right" in {
      getRight(board1, 0, 0) shouldBe Some(dead)
      getRight(board1, 0, 1) shouldBe Some(dead)
      getRight(board1, 1, 0) shouldBe None
      getRight(board1, 1, 1) shouldBe None

      getRight(board2, 0, 0) shouldBe Some(alive)
      getRight(board2, 0, 1) shouldBe Some(dead)
      getRight(board2, 0, 2) shouldBe Some(alive)
      getRight(board2, 1, 0) shouldBe Some(dead)
      getRight(board2, 1, 1) shouldBe Some(dead)
      getRight(board2, 1, 2) shouldBe Some(dead)
      getRight(board2, 2, 0) shouldBe None
      getRight(board2, 2, 1) shouldBe None
      getRight(board2, 2, 2) shouldBe None
    }
    "top right" in {
      getTopRight(board1, 0, 0) shouldBe None
      getTopRight(board1, 0, 1) shouldBe Some(dead)
      getTopRight(board1, 1, 0) shouldBe None
      getTopRight(board1, 1, 1) shouldBe None

      getTopRight(board2, 0, 0) shouldBe None
      getTopRight(board2, 0, 1) shouldBe Some(alive)
      getTopRight(board2, 0, 2) shouldBe Some(dead)
      getTopRight(board2, 1, 0) shouldBe None
      getTopRight(board2, 1, 1) shouldBe Some(dead)
      getTopRight(board2, 1, 2) shouldBe Some(dead)
      getTopRight(board2, 2, 0) shouldBe None
      getTopRight(board2, 2, 1) shouldBe None
      getTopRight(board2, 2, 2) shouldBe None
    }
    "top" in {
      getTopMiddle(board1, 0, 0) shouldBe None
      getTopMiddle(board1, 0, 1) shouldBe Some(alive)
      getTopMiddle(board1, 1, 0) shouldBe None
      getTopMiddle(board1, 1, 1) shouldBe Some(dead)

      getTopMiddle(board2, 0, 0) shouldBe None
      getTopMiddle(board2, 0, 1) shouldBe Some(dead)
      getTopMiddle(board2, 0, 2) shouldBe Some(alive)
      getTopMiddle(board2, 1, 0) shouldBe None
      getTopMiddle(board2, 1, 1) shouldBe Some(alive)
      getTopMiddle(board2, 1, 2) shouldBe Some(dead)
      getTopMiddle(board2, 2, 0) shouldBe None
      getTopMiddle(board2, 2, 1) shouldBe Some(dead)
      getTopMiddle(board2, 2, 2) shouldBe Some(dead)
    }
  }

  "Getting number of live neighbours in total" in {
    countLiveNeighbours(board1, 0, 0) shouldBe 0
    countLiveNeighbours(board1, 1, 0) shouldBe 1
    countLiveNeighbours(board1, 0, 1) shouldBe 1
    countLiveNeighbours(board1, 1, 1) shouldBe 1

    countLiveNeighbours(board2, 0, 0) shouldBe 2
    countLiveNeighbours(board2, 0, 1) shouldBe 3
    countLiveNeighbours(board2, 0, 2) shouldBe 2
    countLiveNeighbours(board2, 1, 0) shouldBe 1
    countLiveNeighbours(board2, 1, 1) shouldBe 4
    countLiveNeighbours(board2, 1, 2) shouldBe 2
    countLiveNeighbours(board2, 2, 0) shouldBe 1
    countLiveNeighbours(board2, 2, 1) shouldBe 2
    countLiveNeighbours(board2, 2, 2) shouldBe 1
  }

}
