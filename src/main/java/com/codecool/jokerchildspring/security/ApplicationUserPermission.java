package com.codecool.jokerchildspring.security;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ApplicationUserPermission {
    ADMIN_STUFF("admin:stuff"),
    STUDENT_STUFF("student:stuff");

    private final String permission;

    public String getPermission() {
        return permission;
    }
}
