package com.example.case_study.controller;

import com.example.case_study.dto.CustomerDto;
import com.example.case_study.model.Customer;
import com.example.case_study.service.ICustomerService;
import com.example.case_study.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("")
    public String search(@RequestParam(value = "name" , defaultValue = "") String name,
                         @PageableDefault(value = 3) Pageable pageable, Model model) {
        model.addAttribute("customers", iCustomerService.findByName(name, pageable));
        model.addAttribute("name", name);
        return "customer/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customerTypes", iCustomerTypeService.findAll());
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasFieldErrors()) {
            return "customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            iCustomerService.save(customer);
            redirectAttributes.addFlashAttribute("masseNew", "successfully added new !!");
            return "redirect:/customer";
        }
    }
}