package calculator.model

class GetNumbers(calculator: Calculator) extends State(calculator) {
  override def calculate(): Unit = {
    calculator.input_num = "0"
    calculator.canDoMathState = new NoMath(calculator)
  }
  override def setFirstNum(): Unit = {
    calculator.firstInput = calculator.input_num
    calculator.input_num = "0"
    calculator.output = 0.0
  }
}
