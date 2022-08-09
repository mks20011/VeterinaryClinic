package org.example.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.model.Order;
import org.example.model.Product;
import org.example.model.ProductOrder;
import org.example.service.OrderService;
import org.example.service.ProductOrderService;
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
    private OrderService orderService;
    private ProductOrderService productOrderService;

    @Autowired
    public void setProductOrderService(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String allProduct(Model model) {
        List<Product> products = productService.allProduct();
        model.addAttribute("productList", products);
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
        model.addAttribute("title", "EDIT");
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

    @GetMapping(value = "/add/getSearchProduct")
    @ResponseBody
    public String check(@RequestParam(value = "id") int id) throws JsonProcessingException {

        Order order = new Order();
        order.setIdUser(8);
        order.setActive(true);
        orderService.add(order);

        ProductOrder productOrder = new ProductOrder();
        productOrder.setIdOrder(order.getId());
        productOrder.setIdProduct(id);
        productOrder.setQuantity(1);
        productOrder.setPrice( productService.getById(id).getPrice());
        productOrder.setAmount( productService.getById(id).getPrice());
        productOrderService.add(productOrder);

        return "Товар успешно добавлен";
    }
}
