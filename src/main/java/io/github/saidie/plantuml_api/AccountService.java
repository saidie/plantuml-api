package io.github.saidie.plantuml_api;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Inject
    private Twitter twitter;

    @Inject
    private ConnectionRepository connectionRepository;

    @Autowired
    private FederationRepository federationRepository;

    @Autowired
    private AccountRepository accountRepository;

    public boolean isIdpAuthenticated() {
        return isTwitterAuthenticated();
    }

    protected boolean isTwitterAuthenticated() {
        return connectionRepository.findPrimaryConnection(Twitter.class) != null;
    }

    public Account getCurrentAccount() {
        // TODO: check cookie

        if (isTwitterAuthenticated()) {
            long id = twitter.userOperations().getUserProfile().getId();
            IdpId idpId = new IdpId(IdpId.FederationType.TWITTER, Long.toString(id));
            Federation federation = federationRepository.findOne(idpId);
            if (federation != null)
                return federation.getAccount();
        }
        return null;
    }

    public Account createAccount(String username) {
        List<Federation> list = new ArrayList<Federation>();

        IdpId idpId = null;
        if (isTwitterAuthenticated()) {
            long id = twitter.userOperations().getUserProfile().getId();
            idpId = new IdpId(IdpId.FederationType.TWITTER, Long.toString(id));
        }
        Account account = new Account();
        Federation federation = new Federation(idpId, account);
        list.add(federation);

        account.setUsername(username);
        account.setFederations(list);

        return accountRepository.save(account);
    }
}
