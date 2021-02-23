package org.example.controller;


import org.example.model.Product;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String allProduct(Model model) {
        List<Product> products = productService.allProduct();
        model.addAttribute("productList",products);
        return "product";
    }

    @GetMapping("/add")
    public String addProduct(@ModelAttribute("editProduct") Product product, Model model) {
        model.addAttribute("title", "ADD");
        model.addAttribute("action", "/product/add");
        return "editPageProduct";
    }

    @PostMapping("/add")
    public String addProduct(@Valid @ModelAttribute("editProduct") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "editPageProduct";
        }
        productService.add(product);
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(Model model, @PathVariable int id) {
        model.addAttribute("title","EDIT");
        model.addAttribute("action", "/product/edit");
        model.addAttribute("editProduct", productService.getById(id));
        return "/editPageProduct";
    }

    @PostMapping("/edit")
    public String editProduct(@Valid @ModelAttribute("editProduct") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "editPageProduct";
        }
        productService.edit(product);
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.delete(productService.getById(id));
        return "redirect:/product";
    }

}
