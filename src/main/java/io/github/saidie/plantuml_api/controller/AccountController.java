package io.github.saidie.plantuml_api.controller;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import io.github.saidie.plantuml_api.model.Account;
import io.github.saidie.plantuml_api.service.AccountService;

@Controller
@RequestMapping("/")
@NoArgsConstructor
public class AccountController {
    @Autowired
    AccountService accountService;

    ProviderSignInUtils providerSignInUtils;

    @Autowired
    public AccountController(ConnectionFactoryLocator connectionFactoryLocator,
                             UsersConnectionRepository connectionRepository) {
        this.accountService = accountService;
        this.providerSignInUtils = new ProviderSignInUtils(connectionFactoryLocator, connectionRepository);
    }

    @RequestMapping(value="/signin", method=RequestMethod.GET)
    public String signin() {
        return "signin";
    }

    @RequestMapping(value="/signup", method=RequestMethod.GET)
    public String signup(WebRequest request) {
        Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);
        if (connection == null)
            return "redirect:/signin";

        String username = connection.fetchUserProfile().getUsername();
        if (username == null || username.isEmpty()) {
            username = "NO NAME";
        }
        Account account = accountService.createAccount(username);

        String userId = Long.toString(account.getId());
        AbstractAuthenticationToken token = new UsernamePasswordAuthenticationToken(userId, null, null);
        SecurityContextHolder.getContext().setAuthentication(token);
        providerSignInUtils.doPostSignUp(userId, request);

        return "redirect:/";
    }
}
