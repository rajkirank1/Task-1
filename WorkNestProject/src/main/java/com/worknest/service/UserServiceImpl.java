package com.worknest.service;

import com.worknest.dao.UserDAO;
import com.worknest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public Long register(User user) {
        return userDAO.save(user);
    }

    @Override
    public User findByEmail(String email) { return userDAO.findByEmail(email); }

    @Override
    public User findById(Long id) { return userDAO.findById(id); }

    @Override
    public List<User> listAll() { return userDAO.findAll(); }
}
