package jp.ken1ma.kaska
package circe

import io.circe
import org.w3c.dom.{Element, Document}

/*
  circe.Decoder cannot be reused for XML since
  1. circe.Decoder.apply takes HCursor
      https://github.com/circe/circe/blob/v0.13.0/modules/core/shared/src/main/scala/io/circe/Decoder.scala#L53
  2. circe.HCursor hardcodes TopCursor
      https://github.com/circe/circe/blob/v0.13.0/modules/core/shared/src/main/scala/io/circe/HCursor.scala#L35
  3. circe.cursor.TopCursor is final and hardcodes Json
      https://github.com/circe/circe/blob/v0.13.0/modules/core/shared/src/main/scala/io/circe/cursor/TopCursor.scala#L5
  4. circe.Json is sealed
      https://github.com/circe/circe/blob/v0.13.0/modules/core/shared/src/main/scala/io/circe/Json.scala#L16
*/
package object xml {
  implicit class ElementOps(el: Element) {
  }

  implicit class DocumentOps(doc: Document) {
    def as
    def as[A](implicit d: Decoder[A]): Decoder.Result[A]
  }
}
