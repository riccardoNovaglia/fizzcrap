import org.scalatest.prop.TableDrivenPropertyChecks.{Table, forAll}
import org.scalatest.{FlatSpec, Matchers}

class FizzBuzzTest extends FlatSpec with Matchers {

  val fizz = new FizzBuzz()

  "FizzBuzz" should "return 'fizz' if the input is divisible by 3" in {
    fizz.toFizzBuzz(3) shouldBe "fizz"
  }

  it should "return 'buzz' if the input is divisible by 5" in {
    fizz.toFizzBuzz(5) shouldBe "buzz"
  }

  it should "return 'fizzbuzz' if the input is divisible by 3 and 5" in {
    fizz.toFizzBuzz(15) shouldBe "fizzbuzz"
  }

  it should "return the number as a string if the input is not divisible by either" in {
    fizz.toFizzBuzz(2) shouldBe "2"
  }

  val upTo20 = Table(
    "input" -> "expected",
    1 -> "1",
    2 -> "2",
    3 -> "fizz",
    4 -> "4",
    5 -> "buzz",
    6 -> "fizz",
    7 -> "7",
    8 -> "8",
    9 -> "fizz",
    10 -> "buzz",
    11 -> "11",
    12 -> "fizz",
    13 -> "13",
    14 -> "14",
    15 -> "fizzbuzz",
    16 -> "16",
    17 -> "17",
    18 -> "fizz",
    19 -> "19",
    20 -> "buzz"
  )

  forAll(upTo20) { (input, expectedOutput) =>
    it should s"convert $input into $expectedOutput" in {
      fizz.toFizzBuzz(input) shouldBe expectedOutput
    }
  }

}
