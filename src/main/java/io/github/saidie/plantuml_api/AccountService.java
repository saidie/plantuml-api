package io.github.saidie.plantuml_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(String username) {
        Account account = new Account(0, username);
        return accountRepository.save(account);
    }
}
