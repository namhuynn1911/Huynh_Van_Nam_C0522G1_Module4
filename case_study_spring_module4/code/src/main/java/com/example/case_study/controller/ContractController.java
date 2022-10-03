package com.example.case_study.controller;

import com.example.case_study.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService iContractService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IAttachFacilityService iAttachFacilityService;

    @Autowired
    private IContractDetailService iContractDetailService;

    @GetMapping("")
    public String showContract(@PageableDefault(value = 3)Pageable pageable, Model model){
        model.addAttribute("contracts",iContractService.findAllContract(pageable));
        return "contract/list";
    }
}
