package calculator.controller;

import calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping("/")
    public String formCalculator() {
        return "index";
    }

    @GetMapping("/calculator")
    public ModelAndView resultCalculator(@RequestParam String operator, @RequestParam String firstNumber,
                                         @RequestParam String lastNumber) {
        return new ModelAndView("index", "result", iCalculatorService.calculator(operator, firstNumber, lastNumber));
    }

}
