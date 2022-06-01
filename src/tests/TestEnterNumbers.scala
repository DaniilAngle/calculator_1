import calculator.model.Calculator
import org.scalatest.funsuite.AnyFunSuite

class TestEnterNumbers extends AnyFunSuite {

  val EPSILON: Double = 0.000001

  def equalDoubles(d1: Double, d2: Double): Boolean = {
    (d1 - d2).abs < EPSILON
  }

  // Example test case
  test("Enter Numbers Test") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(1)
    calculator.numberPressed(2)
    calculator.numberPressed(3)
    calculator.numberPressed(4)
    calculator.numberPressed(5)
    calculator.numberPressed(0)
    calculator.numberPressed(6)
    calculator.decimalPressed()
    calculator.numberPressed(7)
    calculator.numberPressed(8)
    calculator.numberPressed(9)
    assert(equalDoubles(calculator.displayNumber(), 1234506.789), calculator.displayNumber())
  }
  test("zero/decimal test") {
    val calculator: Calculator = new Calculator()
    calculator.numberPressed(0)
    calculator.numberPressed(0)
    calculator.numberPressed(0)
    calculator.numberPressed(0)
    calculator.numberPressed(2)
    calculator.decimalPressed()
    calculator.numberPressed(5)
    assert(equalDoubles(calculator.displayNumber(), 2.5), calculator.displayNumber())
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(5)
    calculator.decimalPressed()
    assert(equalDoubles(calculator.displayNumber(), 2.55), calculator.displayNumber())
  }
  test("only decimal test") {
    val calculator: Calculator = new Calculator()
    calculator.decimalPressed()
    calculator.numberPressed(2)
    assert(equalDoubles(calculator.displayNumber(), 0.2), calculator.displayNumber())
  }
}