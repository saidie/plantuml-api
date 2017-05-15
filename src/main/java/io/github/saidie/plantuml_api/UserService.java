package io.github.saidie.plantuml_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.*;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    public UserDetails loadUserByUsername(String username) {
        Account account = accountRepository.findByUsername(username);

        return new User(username, account.getPassword(), null);
    }
}
