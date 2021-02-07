package com.example.miniproject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String plainPassword = "$2a$10$6y8LbTOi/NA1vM63L8RoWOPnavk1NhUgwpWVfPXtgO1Z3eM3Bowj.";
		String encodedPassword = passwordEncoder.encode(plainPassword);
		
		System.out.println(encodedPassword);
	}

}
