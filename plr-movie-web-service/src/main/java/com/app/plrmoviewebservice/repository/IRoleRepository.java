package com.app.plrmoviewebservice.repository;

import com.app.plrmoviewebservice.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IRoleRepository extends JpaRepository<Role, UUID> {
}
