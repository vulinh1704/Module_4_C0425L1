package com.springdatarepodemo.controller;

import com.springdatarepodemo.entity.Customer;
import com.springdatarepodemo.entity.Type;
import com.springdatarepodemo.service.ICustomerService;
import com.springdatarepodemo.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private TypeService typeService;

    @GetMapping("")
    public ModelAndView index(@RequestParam(name = "search", required = false) String search) {
        if (search == null) search = "";
        ModelAndView modelAndView = new ModelAndView("index");
        List<Customer> customerList = customerService.findByNameContaining(search);
        modelAndView.addObject("customers", customerList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        List<Type> types = this.typeService.findAll();
        modelAndView.addObject("types", types);
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@Validated Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView update(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customers";
    }

    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }
}
