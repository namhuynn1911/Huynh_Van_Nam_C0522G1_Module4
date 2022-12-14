package product_management.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import product_management.model.Product;
import product_management.service.IProductService;

@Controller
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/")
    public String showProduct(Model model) {
        model.addAttribute("product", iProductService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("masse1", "successfully added new !!");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        iProductService.update(product);
        redirectAttributes.addFlashAttribute("messa", "edit successfully!");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Product customer, RedirectAttributes redirect) {
        iProductService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "view";
    }

    @GetMapping("/search")
    public String search(@RequestParam String name, Model model) {
        model.addAttribute("product", iProductService.finByName(name));
        return "list";
    }
}
