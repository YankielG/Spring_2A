package Zjazd3.wszib;

import Zjazd3.wszib.model_2.User;
import Zjazd3.wszib.model_2.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class TestController {

    public static class NotFoundException extends RuntimeException {
    }

    @Autowired
    UserService userService;

    @GetMapping("/listUsers")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "list-users-view";
    }

    @GetMapping("/getUser/{id}")
    public String getUser(@PathVariable String id, Model model) {
        int i = Integer.parseInt(id);
        User user = userService.getUser(i);
        if (user == null) {
            throw new NotFoundException();
        }
        model.addAttribute("user", user);
        return "user-details";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/addUser")
    public String createUser(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "add-user";
        }

        userService.createUser(user.getImie(), user.getNazwisko(), user.getWiek());
        return "redirect:/listUsers";
    }

    @ExceptionHandler(NotFoundException.class)
    public String notFound() {
        return "404";
    }

    //    dodanie z mojego
    @ExceptionHandler(NumberFormatException.class)
    public String wrongFormat() {
        return "numberFormatexception";
    }

    public void validate(User user, BindingResult bindingResult) {
        if (user.getImie() == null || user.getImie().isEmpty()) {
            bindingResult.addError(new ObjectError("imie", "musisz podać imię"));
        }
        if (user.getNazwisko() == null || user.getNazwisko().isEmpty()) {
            bindingResult.addError(new ObjectError("nazwisko", "musisz podać nazwisko"));
        }
        if (user.getWiek() <= 0) {
            bindingResult.addError(new ObjectError("wiek", "musisz podać wiek > 0"));
        }
    }

    //        users.add(new User(15,"Tralala","blble",66));
//        users.add(new User(14,"Tralalsdga","nvvcvcbe",246));
//        users.add(new User(135,"sdfla","blsewrtle",256));
//        users.add(new User(1556,"Tralala","blble",256));
//        users.add(new User(15346,"Tralala","blbrtle",56));
//        users.add(new User(125,"Tralala","blbssle",65));

}
