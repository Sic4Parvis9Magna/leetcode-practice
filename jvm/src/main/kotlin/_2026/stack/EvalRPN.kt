package _2026.stack

class EvalRPN {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>(tokens.size/2)
        for (element in tokens) {
            val intVal = element.toIntOrNull()
            if (intVal != null) {
                stack.addLast(intVal)
            } else {
                val right = stack.removeLast()
                val left = stack.removeLast()
                val calc = when (element) {
                    "-" -> left - right
                    "+" -> left + right
                    "*" -> left * right
                    "/" -> left/right
                    else -> throw IllegalArgumentException("Unknown operand")
                }
                stack.addLast(calc)
            }
        }
        return stack.removeLast()
    }
}

class EvalRPN2 {
    private val validOps = setOf("-", "+", "*", "/")

    fun evalRPN(tokens: Array<String>): Int {
        var currentArray = tokens
        while (currentArray.size != 1) {
            val nextIndex = findNextRPN(currentArray)
            val left = currentArray[nextIndex].toInt()
            val right = currentArray[nextIndex+1].toInt()
            val operand = currentArray[nextIndex+2]
            val currentCalc = calcNextRPN(left, right, operand).toString()
            currentArray = nextRPNArray(currentArray, currentCalc, nextIndex)
        }

        return currentArray[0].toInt()
    }

    private fun nextRPNArray(currentArray: Array<String>, currentCalc: String, nextIndex: Int): Array<String> {
        var res = Array<String>(currentArray.size-2){""}
        currentArray.copyInto(res,0,0,nextIndex)
        res[nextIndex] = currentCalc
        currentArray.copyInto(res, nextIndex+1, nextIndex+3, currentArray.size)
        return res
    }

    private fun calcNextRPN(left: Int, right: Int, operand: String): Int {
        return when (operand) {
            "-" -> left - right
            "+" -> left + right
            "*" -> left * right
            "/" -> left/right
            else -> throw IllegalArgumentException("Unknown operand")
        }
    }

    private fun findNextRPN(array: Array<String>): Int {
        for (i in 0 until array.size-2) {
            if (
                array[i].toIntOrNull() != null
                &&
                array[i+1].toIntOrNull() != null
                &&
                array[i+2] in validOps
            ) {
                return i
            }
        }

        throw IllegalArgumentException("Array w/o RPN")
    }
}