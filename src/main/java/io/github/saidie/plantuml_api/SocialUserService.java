package io.github.saidie.plantuml_api;

import java.util.ArrayList;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SocialUserService implements SocialUserDetailsService {
    public SocialUserDetails loadUserByUserId(String userId) {
        return new SocialUser(userId, "", new ArrayList());
    }
}
