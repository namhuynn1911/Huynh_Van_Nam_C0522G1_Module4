package com.example.case_study.controller;

import com.example.case_study.dto.FacilityDto;
import com.example.case_study.model.Facility;
import com.example.case_study.service.IFacilityService;
import com.example.case_study.service.IFacilityTypeService;
import com.example.case_study.service.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IFacilityTypeService iFacilityTypeService;

    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping("")
    public String showFacility(@RequestParam(value = "name",defaultValue = "")String name,
            @PageableDefault(value = 3) Pageable pageable, Model model) {
        model.addAttribute("facility",iFacilityService.findByNameAll(name,pageable));
        model.addAttribute("name",name);
        return "facility/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("facilityTypes", iFacilityTypeService.findAll());
        model.addAttribute("rentTypes", iRentTypeService.findAll());
        model.addAttribute("facilityDto", new FacilityDto());
        return "facility/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated FacilityDto facilityDto,
                       BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("facilityTypes", iFacilityTypeService.findAll());
            model.addAttribute("rentTypes", iRentTypeService.findAll());
            return "facility/create";
        } else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);

            iFacilityService.save(facility);
            redirectAttributes.addFlashAttribute("masseNew", "successfully added new !!");
            return "redirect:/facility";
        }

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
//        Facility facility = iFacilityService.findById(id);
//        FacilityDto facilityDto = new FacilityDto();
//        BeanUtils.copyProperties(facility, facilityDto);

        model.addAttribute("facility", iFacilityService.findById(id));
        model.addAttribute("facilityTypes", iFacilityTypeService.findAll());
        model.addAttribute("rentTypes", iRentTypeService.findAll());
        return "/facility/edit";
    }

    @PostMapping("/update")
    public String update(Facility facility, RedirectAttributes redirectAttributes) {
//        Facility facility = new Facility();
//        BeanUtils.copyProperties(facilityDto, facility);
        iFacilityService.update(facility);
        redirectAttributes.addFlashAttribute("messa", "edit successfully!");
        return "redirect:/facility";
    }


//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable int id, Model model) {
//        model.addAttribute("facilityTypes", iFacilityTypeService.findAll());
//        model.addAttribute("rentTypes", iRentTypeService.findAll());
//        model.addAttribute("facilitys", iFacilityService.findById(id));
//        return "/facility/delete";
//    }

    @GetMapping("/delete")
    public String delete(@RequestParam(value = "idDelete") int id, RedirectAttributes redirectAttributes) {
        iFacilityService.remove(id);
        redirectAttributes.addFlashAttribute("success", "Xóa dịch vụ  [" +
                iFacilityService.findById(id).getName() + "]  thành công.");
        return "redirect:/facility";
    }

}