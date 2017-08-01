package com;

import android.widget.EditText;

import java.util.Stack;
import java.util.TreeMap;

/**
 * Created by hsenid on 31/07/17.
 */

public class CalOperations {
    private String displayToString;

    public void setDisplay(String buttonClicked, EditText currentDisplay) {
        displayToString = currentDisplay.getText().toString();

        if (!displayToString.matches("")) {
            currentDisplay.setText(displayToString + buttonClicked);
        } else {
            currentDisplay.setText(buttonClicked);
        }
    }

    public Double calculate(EditText expressionToCalculate) {
        displayToString = expressionToCalculate.getText().toString();

        String[] inputArr = displayToString.split(" ");

        Stack<String> operator = new Stack<>();
        Stack<Double> operand = new Stack<>();
        TreeMap<String, Integer> precedence = new TreeMap<String, Integer>();
        precedence.put("+", 1);
        precedence.put("-", 1);
        precedence.put("*", 2);
        precedence.put("/", 2);

        for (int i = 0; i < inputArr.length; i++) {

            String currentToken = inputArr[i];

            if (!precedence.containsKey(currentToken)) {
                operand.push(Double.valueOf(currentToken));
                continue;
            }

            while (true) {

                if (operator.isEmpty() || (precedence.get(currentToken) > precedence.get(operator.peek()))) {
                    operator.push(currentToken);
                    break;
                }

                String op = operator.pop();
                double val2 = Double.valueOf(operand.pop());
                double val1 = Double.valueOf(operand.pop());
                operand.push(eval(op, val1, val2));
            }
        }
        while (!operator.isEmpty()) {
            String op = operator.pop();
            double val2 = operand.pop();
            double val1 = operand.pop();
            operand.push(eval(op, val1, val2));
        }
        return operand.pop();
    }

    public double eval(String op, double val1, double val2) {
        if (op.equals("+")) return val1 + val2;
        if (op.equals("-")) return val1 - val2;
        if (op.equals("/")) return val1 / val2;
        if (op.equals("*")) return val1 * val2;
        throw new RuntimeException("Invalid operator");
    }
}