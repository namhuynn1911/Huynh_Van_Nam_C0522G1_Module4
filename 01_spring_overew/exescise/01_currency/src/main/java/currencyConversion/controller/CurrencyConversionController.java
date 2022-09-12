package currencyConversion.controller;


import currencyConversion.service.ICalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CurrencyConversionController {

    @Autowired
    private ICalculateService iCalculateService;

    @GetMapping("/")
    public String calculate() {

        return "/result";
    }

    @PostMapping("/usd")
    public String currency(String usd, Model model) {

        double result = iCalculateService.convert(usd);
        model.addAttribute("result", result);
        return "/result";
    }
}
