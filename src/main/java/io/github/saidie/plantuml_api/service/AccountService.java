package io.github.saidie.plantuml_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.github.saidie.plantuml_api.model.Account;
import io.github.saidie.plantuml_api.repository.AccountRepository;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(String username) {
        Account account = new Account(0, username);
        return accountRepository.save(account);
    }
}
