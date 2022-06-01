package calculator.bonus

import scala.collection.mutable


object BonusCalculator {
  var output: mutable.MutableList[String] = mutable.MutableList()
  var stack: mutable.MutableList[Char] = mutable.MutableList()
  def dotCheck(c: Char): Boolean = {
    if (c == '.') {
      true
    } else {
      false
    }
  }

  def operatorCheck(c: Char): Int = {
    c match {
      case '(' => -1
      case ')' => 1
      case '+' => 0
      case '-' => 0
      case '*' => 3
      case '/' => 3
    }
  }

  def checkForParenthesis(): Unit = {
    var i: Int = stack.length - 1
    while (stack(i) != '(') {
      output += stack(i).toString
      stack = stack.dropRight(1)
      i -= 1
    }
    stack = stack.dropRight(1)
  }

  def evaluate(expression: String): Double = {
    var valueStr: String = ""

    for (char <- expression) {
      if (char.isDigit) {
        valueStr += char
      } else if (dotCheck(char)) {
        valueStr += char
      } else {
        if (valueStr.nonEmpty) {
          output += valueStr
          valueStr = ""
        }
        if (stack.nonEmpty) {
          if (operatorCheck(stack.last) >= operatorCheck(char) && char != '(' && char != ')') {
            output += stack.last.toString
            stack = stack.dropRight(1)
            stack += char
          } else if (operatorCheck(char) == 1) {
            checkForParenthesis()
          } else {
            stack += char
          }
        }
        if (stack.isEmpty) {
          stack += char
        }
      }
    }
    if (valueStr.nonEmpty) {
      output += valueStr
    }
    for (operator <- stack.reverse) {
      output += operator.toString
      stack = stack.dropRight(1)
    }

    var calc_list: mutable.MutableList[Double] = mutable.MutableList()
    var calculation: Double = 0.0
    for (element <- output) {
      println(calc_list)
      element match {
        case "+" => (calculation = calc_list(calc_list.length - 2) + calc_list.last,
          calc_list = calc_list.dropRight(2), calc_list += calculation)
        case "-" => (calculation = calc_list(calc_list.length - 2) - calc_list.last,
          calc_list = calc_list.dropRight(2), calc_list += calculation)
        case "*" => (calculation = calc_list(calc_list.length - 2) * calc_list.last,
          calc_list = calc_list.dropRight(2), calc_list += calculation)
        case "/" => (calculation = calc_list(calc_list.length - 2) / calc_list.last,
          calc_list = calc_list.dropRight(2), calc_list += calculation)
        case _ => calc_list += element.toDouble
      }
    }
    println(output)
    calculation
  }

  def main(args: Array[String]): Unit = {
    println(evaluate("2+4/2+(23/4)+23/10*10"))
  }
}
