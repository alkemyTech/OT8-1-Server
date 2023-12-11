package com.alkemy.wallet.service;

import com.alkemy.wallet.dto.request.RegisterRequestDto;
import com.alkemy.wallet.dto.response.JwtAuthenticationResponseDto;
import com.alkemy.wallet.entity.Role;
import com.alkemy.wallet.entity.User;
import com.alkemy.wallet.entity.ERole;
import com.alkemy.wallet.repository.RoleRepository;
import com.alkemy.wallet.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final IJwtService jwtService;
    private final AuthenticationManager authManager;

    public AuthServiceImpl(UserRepository userRepository,RoleRepository roleRepository,PasswordEncoder passwordEncoder, JwtServiceImpl jwtService, AuthenticationManager authManager) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authManager = authManager;
    }
    @Override
    public JwtAuthenticationResponseDto registerUser(RegisterRequestDto registerRequest) {
        User newUser = new User();
        newUser.setFirstName(registerRequest.getFirstName());
        newUser.setLastName(registerRequest.getLastName());
        newUser.setEmail(registerRequest.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        Role userRole = roleRepository.findByName(ERole.USER).get();
        //newUser.setRole(userRole);
        //newUser.setAccounts(null);
        userRepository.save(newUser);
        String jwt = jwtService.generateToken(newUser);
        return new JwtAuthenticationResponseDto(
                registerRequest.getEmail(),
                registerRequest.getFirstName(),
                registerRequest.getLastName(),
                jwt
        );
    }
}