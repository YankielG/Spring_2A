package Zjazd3.wszib.model_1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController_1 {

    @GetMapping("/test2")
    public String test(Model model){
        model.addAttribute("imie", "Grzes");
        model.addAttribute("style", "color: red");
        return "list-users-view";

    }
}
