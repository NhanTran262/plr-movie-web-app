package com.app.plrmoviewebservice.repository;

import com.app.plrmoviewebservice.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IRoleRepository extends JpaRepository<Role, UUID> {
}
