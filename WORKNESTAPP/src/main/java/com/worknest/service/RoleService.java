package com.worknest.service;

import com.worknest.model.Role;
import com.worknest.repository.RoleRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }
}
