package com.group.mathproject.service;

import com.group.mathproject.model.Role;
import com.group.mathproject.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
