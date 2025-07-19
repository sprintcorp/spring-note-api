package com.sprintcorp.ecommerce_api.constant;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum UserRole {
    ADMIN,
    USER;

    @JsonCreator
    public static UserRole fromString(String value) {
        return UserRole.valueOf(value.toUpperCase());
    }
}
