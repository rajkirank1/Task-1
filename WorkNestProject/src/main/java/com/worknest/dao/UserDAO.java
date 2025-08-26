package com.worknest.dao;

import com.worknest.model.User;
import java.util.List;

public interface UserDAO {
    Long save(User user);
    User findByEmail(String email);
    User findById(Long id);
    List<User> findAll();
}
