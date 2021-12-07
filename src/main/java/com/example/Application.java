package com.example;

import com.example.entity.RoleEntity;
import com.example.entity.UserEntity;
import com.example.service.impl.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Application {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	PasswordEncoder passwordEncoder(){
//		return new BCryptPasswordEncoder();
//	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
//			userService.saveRoles(new RoleEntity( "ROLE_USER"));
//			userService.saveRoles(new RoleEntity( "ROLE_MANAGER"));
//			userService.saveRoles(new RoleEntity( "ROLE_ADMIN"));
//			userService.saveRoles(new RoleEntity( "ROLE_SUPER_ADMIN"));
//
//			userService.saveUser(new UserEntity("user1","123","vo le quoc dung","active", new ArrayList<>()));
//			userService.saveUser(new UserEntity("user2","123","bui duy khoa","active", new ArrayList<>()));
//			userService.saveUser(new UserEntity("user3","123","ha duc hung","active", new ArrayList<>()));
//			userService.saveUser(new UserEntity("user4","123","lam hoai phu","active", new ArrayList<>()));
//
//			userService.addRoleToUser("user1","ROLE_USER");
//			userService.addRoleToUser("user1","ROLE_MANAGER");
//			userService.addRoleToUser("user2","ROLE_MANAGER");
//			userService.addRoleToUser("user3","ROLE_ADMIN");
//			userService.addRoleToUser("user4","ROLE_ADMIN");
//			userService.addRoleToUser("user4","ROLE_MANAGER");
//			userService.addRoleToUser("user4","ROLE_SUPER_ADMIN");

		};
	}
}