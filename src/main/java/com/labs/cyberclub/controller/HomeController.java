package com.labs.cyberclub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/about")
    public String showAboutPage() {
        return "about";
    }

    @GetMapping("/prices")
    public String showPricesPage() {
        return "price";
    }

    @GetMapping("/workHours")
    public String showWorkingHoursPage() {
        return "workday";
    }

    @GetMapping("/howToFind")
    public String showMapPage() {
        return "map";
    }
}
