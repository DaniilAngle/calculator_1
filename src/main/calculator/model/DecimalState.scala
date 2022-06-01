package calculator.model

class DecimalState(calculator: Calculator) {
  def decimal(): Unit = {
    calculator.input_num += "."
  }
}
