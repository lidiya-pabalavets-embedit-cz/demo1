package com.jrp.demo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class HelloController {

    @RequestMapping(value = "/basic", method = RequestMethod.GET)
    public String sayHello() {
        return "<h1>Hello!</h1>";
    }

    @RequestMapping(value = "/proper", method = RequestMethod.GET)
    public String sayProperHello() {
        return "<h1>Hello, dear user!</h1>";
    }

    @RequestMapping("/user_entry")
    public String userForm() {
        return "<form action=\"/greeting/user_greeting\" method=\"POST\">\n" +
            "  <label for=\"fname\">First name:</label><br>\n" +
            "  <input type=\"text\" id=\"fname\" name=\"firstname\"><br>\n" +
            "  <label for=\"lname\">Last name:</label><br>\n" +
            "  <input type=\"text\" id=\"lname\" name=\"lastname\"><br><br>\n" +
            "  <input type=\"submit\" value=\"Submit\">\n" +
            "</form> ";
    }

    @RequestMapping(value = "/user_greeting", method = RequestMethod.POST)
    public String printUserGreeting(@RequestParam String firstname, @RequestParam String lastname) {
        return "Hello, dear, " + firstname + " " + lastname + "!";
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    public String getOrderId(@PathVariable String id) {
        return "You requested order number " + id;
    }

}
