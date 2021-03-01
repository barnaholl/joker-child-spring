package com.codecool.jokerchildspring.security;

import com.google.common.collect.Sets;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import static com.codecool.jokerchildspring.security.ApplicationUserPermission.*;

@RequiredArgsConstructor
public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet(STUDENT_STUFF)),
    TEACHER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(ADMIN_STUFF));

    private final Set<ApplicationUserPermission> permissions;
}
