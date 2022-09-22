package com.book_loan_app.controller;

import com.book_loan_app.model.BookManager;
import com.book_loan_app.service.IBookManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
public class BookManagerController {

    @Autowired
    private IBookManagerService iBookManagerService;

    @GetMapping("/list")
    public String showBook(@RequestParam(value = "name", defaultValue = "") String name,
                           @PageableDefault(value = 3) Pageable pageable, Model model) {
        model.addAttribute("bookList", iBookManagerService.findIdAndShowBook(name, pageable));
        model.addAttribute("name", name);
        return "list";
    }

    @GetMapping("/borrow/{id}")
    public String showBorrow(@PathVariable int id, Model model) {
        model.addAttribute("book", iBookManagerService.findById(id));

        return "/borrow";
    }

    @PostMapping("/saveBorrow")
    public String saveBorrowBook(BookManager book, RedirectAttributes redirectAttributes) throws Exception {
        iBookManagerService.bookBorrow(book);
        if (book.getAmount()<0){
            throw new Exception();
        }
        redirectAttributes.addFlashAttribute("messa1", "Borrowing books successfully !!!");
        return "redirect:/book/list";
    }

    @GetMapping("/pay/{id}")
    public String showPay(@PathVariable int id, Model model) {
        model.addAttribute("book", iBookManagerService.findById(id));

        return "/pay";
    }
    @PostMapping("/savePay")
    public String savePayBook(BookManager book, RedirectAttributes redirectAttributes) throws Exception {
        iBookManagerService.bookPay(book);
        if (book.getAmount()>book.getCount()){
            throw new Exception();
        }
        redirectAttributes.addFlashAttribute("messa2", "Returned the book !!!");
        return "redirect:/book/list";
    }
}
