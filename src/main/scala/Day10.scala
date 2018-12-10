object Day10 extends AdventIO {
  implicit val s: String = Read("10.txt")

  def main(args: Array[String]): Unit = {
    Write("10a.txt", part1)
    Write("10b.txt", part2.toString)
  }

  // Golf: ? bytes TODO
  def part1(implicit s: String): String = {
    val v: Array[Array[Int]] = s.split('\n').map(x => Array(
      x.substring(10, 16), // position x
      x.substring(17, 24), // position y
      x.substring(36, 38), // velocity x
      x.substring(39, 42) // velocity y
    ).map(_.trim.toInt))
    var sb = new StringBuilder("No solution found")
    for(t <- 0 to 100000) {
      val points = new Array[(Int, Int)](v.length)
      for((l: Array[Int], i: Int) <- v.zipWithIndex) {
        points(i) = (l(0) + t * l(2), l(1) + t * l(3))
      }
      val xRange = (points.minBy(_._1)._1, points.maxBy(_._1)._1)
      val yRange = (points.minBy(_._2)._2, points.maxBy(_._2)._2)
      val width = xRange._2 - xRange._1
      val height = yRange._2 - yRange._1
      if(width <= 100 && height <= 10) {
        val pixels = Array.ofDim[Boolean](width + 1, height + 1)
        for(point <- points) {
          pixels(point._1 - xRange._1)(point._2 - yRange._1) = true
        }
        sb = new StringBuilder
        for(y <- pixels(0).indices) {
          for(x <- pixels.indices) {
            if(pixels(x)(y)) sb.append('#') else sb.append('.')
          }
          sb.append('\n')
        }
      }
    }
    sb.toString
  }

  // Golf: ? bytes TODO
  def part2(implicit s: String): Int = {
    val v: Array[Array[Int]] = s.split('\n').map(x => Array(
      x.substring(10, 16), // position x
      x.substring(17, 24), // position y
      x.substring(36, 38), // velocity x
      x.substring(39, 42) // velocity y
    ).map(_.trim.toInt))
    val tMax = 100000
    var tWhenFound = tMax
    var sb = new StringBuilder("No solution found")
    for(t <- 0 to tMax) {
      val points = new Array[(Int, Int)](v.length)
      for((l: Array[Int], i: Int) <- v.zipWithIndex) {
        points(i) = (l(0) + t * l(2), l(1) + t * l(3))
      }
      val xRange = (points.minBy(_._1)._1, points.maxBy(_._1)._1)
      val yRange = (points.minBy(_._2)._2, points.maxBy(_._2)._2)
      val width = xRange._2 - xRange._1
      val height = yRange._2 - yRange._1
      if(width <= 100 && height <= 10) {
        val pixels = Array.ofDim[Boolean](width + 1, height + 1)
        for(point <- points) {
          pixels(point._1 - xRange._1)(point._2 - yRange._1) = true
        }
        sb = new StringBuilder
        for(y <- pixels(0).indices) {
          for(x <- pixels.indices) {
            if(pixels(x)(y)) sb.append('#') else sb.append('.')
          }
          sb.append('\n')
        }
        tWhenFound = t
      }
    }
    tWhenFound


  }

  def solve(s: String): (String, Int) = {
    val v: Array[Array[Int]] = s.split('\n').map(x => Array(
      x.substring(10, 16), // position x
      x.substring(17, 24), // position y
      x.substring(36, 38), // velocity x
      x.substring(39, 42) // velocity y
    ).map(_.trim.toInt))
    var t = 0
    val tMax = 100000
    var tWhenFound = tMax
    var sb = new StringBuilder("No solution found")
    while(t < tMax) {
      val points = new Array[(Int, Int)](v.length)
      for((l: Array[Int], i: Int) <- v.zipWithIndex) {
        points(i) = (l(0) + t * l(2), l(1) + t * l(3))
      }
      val xRange = (points.minBy(_._1)._1, points.maxBy(_._1)._1)
      val yRange = (points.minBy(_._2)._2, points.maxBy(_._2)._2)
      val width = xRange._2 - xRange._1
      val height = yRange._2 - yRange._1
      if(width <= 100 && height <= 10) {
        val pixels = Array.ofDim[Boolean](width + 1, height + 1)
        for(point <- points) {
          pixels(point._1 - xRange._1)(point._2 - yRange._1) = true
        }
        sb = new StringBuilder
        for(y <- pixels(0).indices) {
          for(x <- pixels.indices) {
            if(pixels(x)(y)) sb.append('#') else sb.append('.')
          }
          sb.append('\n')
        }
        tWhenFound = t
      }
      t += 1
    }
    (sb.toString, tWhenFound)
  }

}