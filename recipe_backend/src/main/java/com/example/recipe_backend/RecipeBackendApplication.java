package com.example.recipe_backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.recipe_backend.entity.ApplicationUser;
import com.example.recipe_backend.entity.Role;
import com.example.recipe_backend.repository.RoleRepo;
import com.example.recipe_backend.repository.UserRepo;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class RecipeBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepo roleRepo, UserRepo userRepo, PasswordEncoder passwordEncoder){
		return  args->{
			if (roleRepo.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole=roleRepo.save(new com.example.recipe_backend.entity.Role("ADMIN"));
			roleRepo.save(new com.example.recipe_backend.entity.Role("USER"));

			Set<Role> roles=new HashSet<>();
			roles.add(adminRole);

			ApplicationUser admin=new ApplicationUser(1,"admin",passwordEncoder.encode("password"),roles);
			userRepo.save(admin);
		};
	}
}
