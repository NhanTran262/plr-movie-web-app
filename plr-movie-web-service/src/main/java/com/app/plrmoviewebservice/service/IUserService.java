package com.app.plrmoviewebservice.service;

import com.app.plrmoviewebservice.domain.dto.request.LoginRequest;
import com.app.plrmoviewebservice.payload.ResponsePayload;

public interface IUserService {
    ResponsePayload register(LoginRequest loginRequest);

    ResponsePayload login(LoginRequest loginRequest);

    ResponsePayload logout();

}
