package com.app.plrmoviewebservice.domain.dto.response;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class LoginResponse {
    private UUID id;
    private String fullName;
    private String username;
    private String email;
    private String phone;
    private List<String> roles;

}
