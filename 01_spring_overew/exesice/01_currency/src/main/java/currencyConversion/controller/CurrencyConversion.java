package currencyConversion.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConversion {


@GetMapping("/")
    public String calculate() {
        return "/result";
    }

    @PostMapping("/usd")
    public String currency(String usd, Model model){
    double result=Double.parseDouble(usd)*23000;
    model.addAttribute("result",result);
     return "/result";
    }
}
