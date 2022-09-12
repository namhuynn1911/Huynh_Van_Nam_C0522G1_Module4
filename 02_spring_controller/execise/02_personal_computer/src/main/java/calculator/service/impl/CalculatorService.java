package calculator.service.impl;

import calculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public String calculator(String operator, String firstNumber, String lastNumber) {

        try {
            double result = 0;
            double number1 = Double.parseDouble(firstNumber);
            double number2 = Double.parseDouble(lastNumber);
            switch (operator) {
                case "Addition":
                    result = number1 + number2;
                    break;
                case "Subtraction":
                    result = number1 - number2;
                    break;
                case "Multiplication":
                    result = number1 * number2;
                    break;
                case "Division":
                    if (number2 == 0) {
                        return "Cannot be divided by 0 !!!";
                    } else {
                        result = number1 / number2;
                        break;
                    }
            }
            return String.valueOf(result);
        } catch (NumberFormatException e) {
            return "Please enter number !!!";
        }
    }
}

