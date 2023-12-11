package com.alkemy.wallet.controller;

import com.alkemy.wallet.entity.Role;
import com.alkemy.wallet.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

  private final RoleService roleService;


  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }

  @GetMapping("/")
  public ResponseEntity<List<Role>> getAllRoles() {
    List<Role> roles = roleService.getAllRoles();
    return new ResponseEntity<>(roles, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
    Role role = roleService.getRoleById(id);
    return new ResponseEntity<>(role, HttpStatus.OK);
  }

  @PostMapping("/")
  public ResponseEntity<Role> createRole(@RequestBody Role role) {
    Role createdRole = roleService.createRole(role);
    return new ResponseEntity<>(createdRole, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role role) {
    Role updatedRole = roleService.updateRole(id, role);
    return new ResponseEntity<>(updatedRole, HttpStatus.OK);
  }
}
