package sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class sandwichController {

    @GetMapping("/")
    public String formSandwich() {
        return "index";
    }

    @GetMapping("/save")
    public String sandwichList(@RequestParam String[] condiments, ModelMap modelMap) {
        modelMap.addAttribute("condiments", condiments);
        return "list";
    }

}
