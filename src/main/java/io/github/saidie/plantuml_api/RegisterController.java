package io.github.saidie.plantuml_api;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
@NoArgsConstructor
public class RegisterController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(method=RequestMethod.GET)
    public String registerForm() {
        if (!accountService.isIdpAuthenticated())
            return "redirect:/connect";

        if (accountService.getCurrentAccount() != null)
            return "redirect:/";

        return "register";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String register(@RequestParam("username") String username) {
        // TODO: CSRF

        if (!accountService.isIdpAuthenticated())
            return "redirect:/connect";

        if (accountService.getCurrentAccount() != null)
            return "redirect:/";

        accountService.createAccount(username);

        // TODO: issue cookie

        return "redirect:/";
    }
}
