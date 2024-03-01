package com.example.recipe_backend.services;


import com.example.recipe_backend.entity.ApplicationUser;
import com.example.recipe_backend.entity.Role;
import com.example.recipe_backend.pojo.LoginResponse;
import com.example.recipe_backend.repository.RoleRepo;
import com.example.recipe_backend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;
    @Autowired
    public AuthenticationService(UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    public ApplicationUser registerUser(String username,String password){
        String encodedPassword=passwordEncoder.encode(password);
        Role userRole=roleRepo.findByAuthority("USER").get();

        Set<Role> authorities=new HashSet<>();

        authorities.add(userRole);
        return userRepo.save(new ApplicationUser(0,username,encodedPassword,authorities));
    }

    public LoginResponse loginUser(String username,String password){
        try {
            Authentication auth= authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username,password)
            );
            String token=tokenService.generateJwt(auth);
            return  new LoginResponse(userRepo.findByUsername(username).get(),token);
        }catch (Exception e){
            e.printStackTrace();
            return  new LoginResponse(null,null);
        }
    }


}
