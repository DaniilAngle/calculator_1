import calculator.model.Calculator
import org.scalatest.funsuite.AnyFunSuite

class TestFullFunctionality extends AnyFunSuite {

  val EPSILON: Double = 0.000001

  def equalDoubles(d1: Double, d2: Double): Boolean = {
    (d1 - d2).abs < EPSILON
  }

  test("calculation with result of the previous calculation") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(4)
    calculator.addPressed()
    calculator.numberPressed(8)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 12), calculator.displayNumber())
    calculator.dividePressed()
    calculator.numberPressed(3)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 4), calculator.displayNumber())
  }

  test("multiple equals press functionality addition") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(4)
    calculator.addPressed()
    calculator.numberPressed(8)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 12), calculator.displayNumber())
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 20), calculator.displayNumber())
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 28), calculator.displayNumber())
  }

  test("multiple equals press functionality subtraction") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(4)
    calculator.subtractPressed()
    calculator.numberPressed(8)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), -4), calculator.displayNumber())
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), -12), calculator.displayNumber())
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), -20), calculator.displayNumber())
  }

  test("multiple equals press functionality multiplication") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(4)
    calculator.multiplyPressed()
    calculator.numberPressed(2)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 8), calculator.displayNumber())
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 16), calculator.displayNumber())
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 32), calculator.displayNumber())
  }

  test("multiple equals press functionality division") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(8)
    calculator.dividePressed()
    calculator.numberPressed(2)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 4), calculator.displayNumber())
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 2), calculator.displayNumber())
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 1), calculator.displayNumber())
  }

  test("multiple sign press functionality") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(8)
    calculator.dividePressed()
    calculator.subtractPressed()
    calculator.multiplyPressed()
    calculator.addPressed()
    calculator.numberPressed(2)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 10), calculator.displayNumber())
  }

  test("multiple addition calculation press functionality") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(8)
    calculator.addPressed()
    calculator.numberPressed(2)
    calculator.addPressed()
    assert(equalDoubles(calculator.displayNumber(), 10), calculator.displayNumber())
    calculator.numberPressed(8)
    calculator.addPressed()
    assert(equalDoubles(calculator.displayNumber(), 18), calculator.displayNumber())
    calculator.numberPressed(4)
    calculator.addPressed()
    assert(equalDoubles(calculator.displayNumber(), 22), calculator.displayNumber())
  }

  test("multiple subtraction calculation press functionality") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(8)
    calculator.subtractPressed()
    calculator.numberPressed(2)
    calculator.subtractPressed()
    assert(equalDoubles(calculator.displayNumber(), 6), calculator.displayNumber())
    calculator.numberPressed(1)
    calculator.subtractPressed()
    assert(equalDoubles(calculator.displayNumber(), 5), calculator.displayNumber())
    calculator.numberPressed(4)
    calculator.subtractPressed()
    assert(equalDoubles(calculator.displayNumber(), 1), calculator.displayNumber())
  }

  test("multiple division calculation press functionality") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(8)
    calculator.dividePressed()
    calculator.numberPressed(2)
    calculator.dividePressed()
    assert(equalDoubles(calculator.displayNumber(), 4), calculator.displayNumber())
    calculator.numberPressed(4)
    calculator.dividePressed()
    assert(equalDoubles(calculator.displayNumber(), 1), calculator.displayNumber())
    calculator.numberPressed(2)
    calculator.dividePressed()
    assert(equalDoubles(calculator.displayNumber(), 0.5), calculator.displayNumber())
  }

  test("multiple multiplication calculation press functionality") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(8)
    calculator.multiplyPressed()
    calculator.numberPressed(2)
    calculator.multiplyPressed()
    assert(equalDoubles(calculator.displayNumber(), 16), calculator.displayNumber())
    calculator.numberPressed(4)
    calculator.multiplyPressed()
    assert(equalDoubles(calculator.displayNumber(), 64), calculator.displayNumber())
    calculator.numberPressed(2)
    calculator.multiplyPressed()
    assert(equalDoubles(calculator.displayNumber(), 128), calculator.displayNumber())
  }

  test("multiple calculations functionality") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(8)
    calculator.multiplyPressed()
    calculator.numberPressed(2)
    calculator.addPressed()
    assert(equalDoubles(calculator.displayNumber(), 16), calculator.displayNumber())
    calculator.numberPressed(4)
    calculator.subtractPressed()
    assert(equalDoubles(calculator.displayNumber(), 20), calculator.displayNumber())
    calculator.numberPressed(2)
    calculator.dividePressed()
    assert(equalDoubles(calculator.displayNumber(), 18), calculator.displayNumber())
    calculator.numberPressed(6)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 3), calculator.displayNumber())
  }

  test("equal does nothing in moments") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(8)
    calculator.equalsPressed()
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 8), calculator.displayNumber())
    calculator.multiplyPressed()
    calculator.equalsPressed()
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 0.0), calculator.displayNumber())
    calculator.numberPressed(2)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 16), calculator.displayNumber())
  }

  test("clear button") {
    val calculator: Calculator = new Calculator()

    calculator.numberPressed(8)
    calculator.clearPressed()
    assert(equalDoubles(calculator.displayNumber(), 0), calculator.displayNumber())
    calculator.numberPressed(6)
    calculator.multiplyPressed()
    calculator.numberPressed(2)
    calculator.clearPressed()
    assert(equalDoubles(calculator.displayNumber(), 0), calculator.displayNumber())
    calculator.numberPressed(2)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 2), calculator.displayNumber())
    calculator.subtractPressed()
    calculator.numberPressed(4)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), -2), calculator.displayNumber())
    calculator.clearPressed()
    assert(equalDoubles(calculator.displayNumber(), 0), calculator.displayNumber())
  }


}
