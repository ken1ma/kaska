package jp.ken1ma.kaska
package circe.xml

import java.nio.charset.StandardCharsets.UTF_8
import java.io.{InputStream, ByteArrayInputStream}
import javax.xml.parsers.DocumentBuilderFactory

import org.w3c.dom.Document

object XmlParser {
  val docBuilderFactory = DocumentBuilderFactory.newInstance

  def parse(in: InputStream): Document = {
    val docBuilder = docBuilderFactory.newDocumentBuilder // docBuilder is not thread safe
    docBuilder.parse(in)
  }
  def parse(bin: Array[Byte]): Document = parse(new ByteArrayInputStream(bin))
  def parse(string: String  ): Document = parse(string.getBytes(UTF_8))
}
