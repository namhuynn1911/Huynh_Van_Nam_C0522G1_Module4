package com.example.case_study.controller;

import com.example.case_study.dto.EmployeeDto;
import com.example.case_study.model.Customer;
import com.example.case_study.model.Employee;
import com.example.case_study.service.IDivisionService;
import com.example.case_study.service.IEducationDegreeService;
import com.example.case_study.service.IEmployeeService;
import com.example.case_study.service.IPositionService;
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
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IEducationDegreeService iEducationDegreeService;

    @Autowired
    private IPositionService iPositionService;

    @Autowired
    private IDivisionService iDivisionService;

    @GetMapping("")
    public String showEmployeeSearch(@RequestParam(value = "name",defaultValue = "") String name,
                                     @RequestParam(value = "phone",defaultValue = "")String phone,
                                     @RequestParam(value = "idCard",defaultValue = "")String idCard,
                                     @PageableDefault(value = 3)Pageable pageable, Model model){
        model.addAttribute("employees",iEmployeeService.findByName(name,phone,idCard,pageable));
        model.addAttribute("name",name);
        model.addAttribute("phone",phone);
        model.addAttribute("idCard",idCard);
        return "employee/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("educationDegrees", iEducationDegreeService.findAll());
        model.addAttribute("positions", iPositionService.findAll());
        model.addAttribute("divisions",iDivisionService.findAll());
        model.addAttribute("employeeDto", new EmployeeDto());
        return "employee/create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute @Validated EmployeeDto employeeDto, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model) {

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("educationDegrees", iEducationDegreeService.findAll());
            model.addAttribute("positions", iPositionService.findAll());
            model.addAttribute("divisions", iDivisionService.findAll());
            return "employee/create";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            iEmployeeService.save(employee);
            redirectAttributes.addFlashAttribute("masseNew", "successfully added new !!");
            return "redirect:/employee";
        }
    }

    @GetMapping("/update/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("employees", iEmployeeService.findById(id));
        model.addAttribute("educationDegrees", iEducationDegreeService.findAll());
        model.addAttribute("positions", iPositionService.findAll());
        model.addAttribute("divisions", iDivisionService.findAll());
        return "employee/update";
    }

    @PostMapping("/update")
    public String update(Employee employee, RedirectAttributes redirectAttributes) {
        iEmployeeService.update(employee);
        redirectAttributes.addFlashAttribute("messa", "edit successfully!");
        return "redirect:/employee";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("employees", iEmployeeService.findById(id));
//        model.addAttribute("educationDegrees",iEducationDegreeService.findAll());
//        model.addAttribute("positions",iPositionService.findAll());
//        model.addAttribute("divisions",iDivisionService.findAll());
        return "employee/list";
    }

    @PostMapping("/delete")
    public String delete(Employee employee, RedirectAttributes redirect) {
        iEmployeeService.remove(employee.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/employee";
    }
}
