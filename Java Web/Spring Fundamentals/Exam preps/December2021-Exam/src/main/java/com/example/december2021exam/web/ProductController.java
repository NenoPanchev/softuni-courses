package com.example.december2021exam.web;

import com.example.december2021exam.model.binding.ProductAddBindingModel;
import com.example.december2021exam.model.service.ProductServiceModel;
import com.example.december2021exam.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;

    public ProductController(ProductService productService, ModelMapper modelMapper, HttpSession httpSession) {
        this.productService = productService;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }

    @GetMapping("/add")
    public String add() {
        if  (httpSession.getAttribute("user") == null) {
            return "redirect:/";
        }
        return "product-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ProductAddBindingModel productAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel", bindingResult);
            return "redirect:add";
        }
        productService.addProduct(modelMapper.map(productAddBindingModel, ProductServiceModel.class));
        return "redirect:/";
    }

    @GetMapping("/buy/{id}")
    public String buy(@PathVariable("id") Long id) {
        if  (httpSession.getAttribute("user") == null) {
            return "redirect:/";
        }
        this.productService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/buy/all")
    public String buyAll() {
        if  (httpSession.getAttribute("user") == null) {
            return "redirect:/";
        }
        this.productService.deleteAll();
        return "redirect:/";
    }

    @ModelAttribute
    public ProductAddBindingModel productAddBindingModel() {
        return new ProductAddBindingModel();
    }
}
