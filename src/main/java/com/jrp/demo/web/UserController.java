package com.jrp.demo.web;

import com.jrp.demo.domain.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/{userId}")
    public String displayUser(@PathVariable Integer userId) {
        return "User with id " + userId + " has coming";
    }

    @RequestMapping("/{userId}/invoices")
    public String displayInvoices(@PathVariable Integer userId, @RequestParam(value = "d", required = false) Date dateOrNull) {
        return "There are for user " + userId + " for date " + dateOrNull + " some invoices";
    }

    @RequestMapping("/{userId}/items")
    public List<String> displayItems() {
        return Arrays.asList("Umbrella", "donut", "sofa");
    }

    @RequestMapping("/{userId}/items_as_products")
    public List<Product> displayItemsAsJson() {
        return Arrays.asList(new Product(1, "camomile", 2.3),
            new Product(2, "rose", 45.0),
            new Product(3, "daffodil", 20.5));
    }

}
