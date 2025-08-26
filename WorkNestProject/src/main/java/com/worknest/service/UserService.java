package com.worknest.service;

import com.worknest.model.User;
import java.util.List;

public interface UserService {
    Long register(User user);
    User findByEmail(String email);
    User findById(Long id);
    List<User> listAll();
}
