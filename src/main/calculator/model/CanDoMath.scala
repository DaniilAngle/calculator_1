package calculator.model

class CanDoMath(calculator: Calculator) {
  def doMathOperator(): Unit = {
    calculator.state.calculate()
  }
}
