package com.example_blog.controller;


import com.example_blog.model.Blogs;
import com.example_blog.service.IBlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogsController {

    @Autowired
    private IBlogsService iBlogsService;

    @GetMapping({"/blogs","/"})
    public String showBlogs(Model model) {
        model.addAttribute("blogs", iBlogsService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blogs", new Blogs());
        return "create";
    }

    @PostMapping("/save")
    public String save(Blogs blogs, RedirectAttributes redirectAttributes) {
        iBlogsService.save(blogs);
        redirectAttributes.addFlashAttribute("masseNew", "successfully added new !!");
        return "redirect:/blogs";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blogs", iBlogsService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Blogs blogs, RedirectAttributes redirectAttributes) {
        iBlogsService.update(blogs);
        redirectAttributes.addFlashAttribute("messa", "edit successfully!");
        return "redirect:/blogs";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("blogs", iBlogsService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Blogs blogs, RedirectAttributes redirect) {
        iBlogsService.remove(blogs.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/blogs";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blogs", iBlogsService.findById(id));
        return "view";
    }
}
