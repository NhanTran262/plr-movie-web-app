package com.app.plrmoviewebservice.model.utils;

import com.app.plrmoviewebservice.model.entity.User;
import com.app.plrmoviewebservice.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class SecurityUtility {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityUtility.class);
    private final IUserRepository userRepository;

    public Optional<User> getCurrentUser() {
        LOGGER.info("SecurityUtility -> get current user invoked!");
        Authentication authentication = SecurityContextHolder
                .getContext().getAuthentication();
        if (Optional.ofNullable(authentication).isPresent() && authentication.isAuthenticated()) {
            return userRepository.findByUsername(authentication.getName());
        }
        return Optional.empty();
    }
}
