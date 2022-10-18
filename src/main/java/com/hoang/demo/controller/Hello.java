package com.hoang.demo.controller;

import com.hoang.demo.domain.HelloService;
import com.hoang.demo.infra.entity.Customer;
import com.hoang.demo.model.InputHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Hello {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String hello (@RequestBody InputHello input) {
        return "Hello world";
    }

    @PostMapping("/hello/guest")
    public String hello2 (@RequestBody InputHello input) {
        return "Hello " + input.getName();
    }


    @GetMapping("/customer")
    public List<Customer> customer (@RequestBody InputHello input) {
        return helloService.getCustomerList();
    }

    @GetMapping("/search")
    public Customer getcustomerbyID (@RequestParam(name = "id") int id  ) {
        return helloService.searchId(id);
    }

    @GetMapping("/searchnameage")
    public List<Customer> getcustomerbyName (@RequestParam(name = "name") String name) {
        return helloService.getCustomerbyName(name);
    }

    @PostMapping("/customer")
    public String addNew (@RequestBody InputHello input) {
        Customer customer = new Customer();
        customer.setName(input.getName());
        customer.setAge(input.getAge());
        return helloService.addNew(customer);
    }

    @PutMapping("/customer")
    public String put (@RequestBody InputHello input) {
        Customer customer = new Customer();
        customer.setId(input.getId());
        customer.setName(input.getName());
        customer.setAge(input.getAge());

        return helloService.put(customer);
    }

    @DeleteMapping("/customer")
    public String del (@RequestBody InputHello input) {
        Customer customer = new Customer();
        customer.setId(input.getId());

        return helloService.del(customer);
    }
}
