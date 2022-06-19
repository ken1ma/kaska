package jp.ken1ma.kaska
package circe.xml

import io.circe, circe.generic.auto._
import org.scalatest.freespec.AnyFreeSpec

import xml.syntax._

class CirceXmlTest extends AnyFreeSpec with TestHelper {
  "XML" - {
    "SingleString" in {
      assert(XmlParser.parse("""
        <string>ほげ</string>
      """).as[SingleString].getOrThrow == SingleString("ほげ"))
    }
  }
}
