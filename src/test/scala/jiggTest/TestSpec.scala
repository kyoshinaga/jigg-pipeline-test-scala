package jiggTest

import java.util.Properties

import org.scalatest._

class TestSpec extends FlatSpec with Matchers {
  import jigg.pipeline.Pipeline

  "one" should "equal one" in {
    1 should be (1)
  }
}
