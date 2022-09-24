package com.example.cart.controller;

import com.example.cart.dto.CartDto;
import com.example.cart.dto.ProductDto;
import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@SessionAttributes("product")
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @ModelAttribute("product")
    public CartDto initCard() {
        return new CartDto();
    }

    @GetMapping("")
    public String showList(Model model, @CookieValue(value = "idProduct", defaultValue = "-1") int idProduct) {
        if (idProduct != -1) {
            model.addAttribute("historyProduct", iProductService.findById(idProduct).get());
        }
        model.addAttribute("productList", iProductService.findAll());
        return "list";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable int id, Model model, HttpServletResponse response) {
        Cookie cookie = new Cookie("idProduct", id + "");
        cookie.setMaxAge(60 * 60 * 24 * 1);
        cookie.setPath("/");
        response.addCookie(cookie);

        model.addAttribute("products", iProductService.findById(id).get());
        return "detail";
    }

    @GetMapping("/add/{id}")
    public String addCart(@PathVariable int id, @SessionAttribute("product") CartDto cartDto) {
        Optional<Product> productOptional = iProductService.findById(id);
        if (productOptional.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(), productDto);
            cartDto.addProduct(productDto);
        }
        return "redirect:/cart";
    }
    @GetMapping("/remove/{id}")
    public String removeCart(@PathVariable int id,@SessionAttribute("product") CartDto cartDto){
        Optional<Product> optionalProduct=iProductService.findById(id);
        if(optionalProduct.isPresent()){
            ProductDto productDto=new ProductDto();
            BeanUtils.copyProperties(optionalProduct.get(),productDto);
            cartDto.removeProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id, @SessionAttribute("product") CartDto cartDto) {
        Optional<Product> productOptional = iProductService.findById(id);
        if (productOptional.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(), productDto);
            cartDto.deleteProduct(productDto);
        }
        return "redirect:/cart";
    }
}
