package calculator.model

class NoMath(calculator: Calculator) extends CanDoMath(calculator) {
  override def doMathOperator(): Unit = {}
}
