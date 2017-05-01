package io.github.saidie.plantuml_api;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
@NoArgsConstructor
public class LoginController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(method=RequestMethod.GET)
    public String login() {
        if (!accountService.isIdpAuthenticated())
            return "redirect:/connect/twitter";

        if (accountService.getCurrentAccount() == null)
            return "redirect:/register";

        return "redirect:/";
    }
}
