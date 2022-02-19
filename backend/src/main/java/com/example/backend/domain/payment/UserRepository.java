package com.example.backend.domain.payment;

import javax.validation.constraints.NotNull;

public interface UserRepository {
    @NotNull
    public User findById(String userId);

}
