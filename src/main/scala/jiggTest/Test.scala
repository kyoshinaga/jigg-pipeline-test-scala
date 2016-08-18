package jiggTest

import jigg.pipeline.Pipeline
import java.util.Properties
import scala.xml.Node

class Test() {
  val hoge:String = "hoge"
}

object Test {
  def main(args: Array[String]): Unit = {
    val props = new Properties

    props.setProperty("annotators", "corenlp[tokenize, ssplit]")

    val pipeline = new Pipeline(props)

    val text: String = "Hello, jigg."

    val annotation: Node = pipeline.annotate(text)
  }
}
