package com.alkemy.wallet.service;

import com.alkemy.wallet.entity.Role;
import com.alkemy.wallet.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;


    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        return roleOptional.orElse(null);
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role updateRole(Long id, Role newRole) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isPresent()) {
            Role existingRole = optionalRole.get();
            existingRole.setName(newRole.getName());
            existingRole.setDescription(newRole.getDescription());
        
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            
            existingRole.setUpdateDate(timestamp); 
            return roleRepository.save(existingRole);
        } else {
            return null;
        }
    }
}

