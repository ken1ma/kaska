package jp.ken1ma.kaska
package circe.xml

import scala.util.{Either, Right, Left}

trait TestHelper {
  case class SingleString(string: String)

  implicit class EitherOps[A, B](either: Either[A, B]) {
    def getOrThrow(implicit ev: A <:< Throwable): B = either match {
      case Right(value) => value
      case Left(ex)     => throw ex
    }
  }
}
