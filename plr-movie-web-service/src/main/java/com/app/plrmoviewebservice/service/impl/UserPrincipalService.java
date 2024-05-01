package com.app.plrmoviewebservice.service.impl;

import com.app.plrmoviewebservice.domain.entity.User;
import com.app.plrmoviewebservice.repository.IUserRepository;
import com.app.plrmoviewebservice.security.UserPrincipal;
import com.app.plrmoviewebservice.service.IUserPrincipalService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserPrincipalService implements IUserPrincipalService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserPrincipalService.class);
    private final IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("UserPrincipalService -> load user by username invoked!");
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        return UserPrincipal.mapUserToUserDetails(user);
    }
}
