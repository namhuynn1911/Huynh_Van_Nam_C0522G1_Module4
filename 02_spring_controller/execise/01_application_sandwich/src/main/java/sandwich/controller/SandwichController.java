package sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {

    @GetMapping("/")
    public String formSandwich() {
        return "index";
    }

    @GetMapping("/save")
    public ModelAndView sandwichList(@RequestParam(value = "condiments",defaultValue = "")String[] condiments ) {
        ModelAndView modelAndView=new ModelAndView("list");
        if (condiments.length == 0) {
            modelAndView.addObject("condiments", "Haven't chosen seasoning yet !!");
        } else {
            modelAndView.addObject("condiments", condiments);
        }
        return modelAndView;
    }
}
