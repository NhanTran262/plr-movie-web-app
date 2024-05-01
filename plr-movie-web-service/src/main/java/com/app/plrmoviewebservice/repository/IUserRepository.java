package com.app.plrmoviewebservice.repository;

import com.app.plrmoviewebservice.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IUserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);

//    List<String> findRolesByUsername(String username);
}
