package mailbox.controller;

import mailbox.model.EmailBox;
import mailbox.service.IEmailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailController {

    @Autowired
    private IEmailBoxService iEmailBoxService;

    @GetMapping("/")
    public ModelAndView showList() {
        return new ModelAndView("list", "emailBoxList", iEmailBoxService.findAll());
    }

    @GetMapping("/update")
    public String showEmail(@RequestParam Integer id, Model model) {
        model.addAttribute("emailBoxList",  iEmailBoxService.findById(id));
        model.addAttribute("languagesList", iEmailBoxService.findLanguagesAll());
        model.addAttribute("pageSizeList", iEmailBoxService.findSizeAll());
        return "update";
    }

    @PostMapping("/save")
    public String update(@ModelAttribute EmailBox emailBox, RedirectAttributes redirectAttributes){
        iEmailBoxService.update(emailBox);
        redirectAttributes.addFlashAttribute("masse","Sửa thành công");
        return "redirect:/";
    }

}
