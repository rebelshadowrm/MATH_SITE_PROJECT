package com.group.mathproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MathprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MathprojectApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	/*
	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_STUDENT"));
			userService.saveRole(new Role(null, "ROLE_PARENT"));
			userService.saveRole(new Role(null, "ROLE_TEACHER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));

			userService.saveUser(new User(
					null,
					"Admin",
					"password",
					"email@email.com",
					"Admin",
					"User",
					new ArrayList<>()
			));

			userService.addRoleToUser("Admin", "ROLE_ADMIN");
		};
	}
	 */


}
