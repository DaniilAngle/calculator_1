package calculator.model

class Multiplication(calculator: Calculator) extends GetNumbers(calculator) {
  override def calculate(): Unit = {
    calculator.output = calculator.firstInput.toDouble * calculator.secondInput.toDouble
    calculator.firstInput = calculator.output.toString
    super.calculate()
  }
  override def setFirstNum(): Unit = {}

  override def possibleEval(): Unit = {
    calculator.equalsState = new EqualsWorks(calculator)
  }
  override def turnOnEqual(): Unit = {
    calculator.equalsState = new EqualsWorks(calculator)
  }
}
