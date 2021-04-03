package spring.fundamentals.springbootlab.services.impl;

import org.springframework.stereotype.Service;
import spring.fundamentals.springbootlab.repositories.RoleRepository;
import spring.fundamentals.springbootlab.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
