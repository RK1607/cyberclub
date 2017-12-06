package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/prices")
    public String showPricesPage() {
        return "price";
    }

    @GetMapping("/workingHours")
    public String showWorkingHoursPage() {
        return "workday";
    }

    @GetMapping("/howToFind")
    public String showMapPage()
    {
        return "map";
    }
}
