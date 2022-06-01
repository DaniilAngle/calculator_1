package calculator.model

class EqualsWorks(calculator: Calculator) {
  def doMath(): Unit = {
    calculator.state.calculate()
  }
}
