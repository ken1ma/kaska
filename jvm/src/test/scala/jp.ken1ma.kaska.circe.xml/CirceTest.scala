package jp.ken1ma.kaska
package circe.xml

import io.circe, circe.generic.auto._, circe.syntax._, circe.parser.parse
import org.scalatest.freespec.AnyFreeSpec

class CirceTest extends AnyFreeSpec with TestHelper {
  "JSON" - {
    "SingleString" in {
      assert(parse("""
        {
          "string": "ほげ"
        }
      """).getOrThrow.as[SingleString].getOrThrow == SingleString("ほげ"))
    }
  }
}
