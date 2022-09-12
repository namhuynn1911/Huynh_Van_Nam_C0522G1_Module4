package customerManagement.controller;

import customerManagement.model.Customer;
import customerManagement.service.ISimpleCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
private ISimpleCustomerService iSimpleCustomerService;

@GetMapping("/")
    public  ModelAndView showList(){
        return new ModelAndView("/customer/list","customerList",iSimpleCustomerService.findAll());
    }
}
