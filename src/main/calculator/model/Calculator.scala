package calculator.model


class Calculator() {
  var firstInput: String = ""
  var secondInput: String = ""
  var output: Double = 0.0
  var input_num: String = "0"
  var state: State = new GetNumbers(this)
  var decimalState: DecimalState = new DecimalState(this)
  var equalsState: EqualsWorks = new EqualsPass(this)
  var canDoMathState: CanDoMath = new NoMath(this)

  def displayNumber(): Double = {
    output
  }

  def clearPressed(): Unit = {
    output = 0.0
    input_num = "0"
    firstInput = ""
    secondInput = ""
    decimalState = new DecimalState(this)
    state = new GetNumbers(this)
    equalsState = new EqualsPass(this)
  }

  def numberPressed(number: Int): Unit = {
    input_num += number.toString
    secondInput = input_num
    output = input_num.toDouble
    state.possibleEval()
    canDoMathState = new CanDoMath(this)
    state.turnOnEqual()
  }

  def dividePressed(): Unit = {
    state.setFirstNum()
    canDoMathState.doMathOperator()
    decimalState = new DecimalState(this)
    state = new Division(this)
  }

  def multiplyPressed(): Unit = {
    state.setFirstNum()
    canDoMathState.doMathOperator()
    decimalState = new DecimalState(this)
    state = new Multiplication(this)
  }

  def subtractPressed(): Unit = {
    state.setFirstNum()
    canDoMathState.doMathOperator()
    decimalState = new DecimalState(this)
    state = new Subtraction(this)
  }

  def addPressed(): Unit = {
    state.setFirstNum()
    canDoMathState.doMathOperator()
    decimalState = new DecimalState(this)
    state = new Addition(this)
  }

  def equalsPressed(): Unit = {
    equalsState.doMath()
  }

  def decimalPressed(): Unit = {
    decimalState.decimal()
    decimalState = new DotPressed(this)
  }
}