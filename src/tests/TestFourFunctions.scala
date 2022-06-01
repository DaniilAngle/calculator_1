import calculator.model.Calculator
import org.scalatest.funsuite.AnyFunSuite

class TestFourFunctions extends AnyFunSuite {

  val EPSILON: Double = 0.000001

  def equalDoubles(d1: Double, d2: Double): Boolean = {
    (d1 - d2).abs < EPSILON
  }

  test("multiply test") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(5)
    calculator.multiplyPressed()
    calculator.numberPressed(3)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 15), calculator.displayNumber())
  }

  test("division test") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(5)
    calculator.numberPressed(5)
    calculator.dividePressed()
    calculator.numberPressed(10)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 5.5), calculator.displayNumber())
  }

  test("addition test") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(1)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(2)
    calculator.decimalPressed()
    calculator.addPressed()
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(6)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 1.8), calculator.displayNumber())
  }

  test("subtraction test") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(1)
    calculator.numberPressed(5)
    calculator.decimalPressed()
    calculator.subtractPressed()
    calculator.numberPressed(4)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(6)
    calculator.decimalPressed()
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 10.4), calculator.displayNumber())
  }
}
