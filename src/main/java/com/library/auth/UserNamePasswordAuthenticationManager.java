package com.library.auth;

import com.library.repository.models.User;
import com.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hojha on 23/10/16.
 */
public class UserNamePasswordAuthenticationManager implements AuthenticationManager {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        User user = userService.findUser(email, password);
        if (user == null) {
            return null;
        }
        String clientId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password, null);
        Map<String, Object> details = new HashMap<>();
        details.put("userId", email);
        details.put("clientId", clientId);
        authenticationToken.setDetails(details);
        return authenticationToken;
    }
}
