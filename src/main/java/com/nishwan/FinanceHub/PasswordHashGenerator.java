package com.nishwan.FinanceHub;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashGenerator {

    public static void main(String[] args) {

        String rawPassword = "analyst123";

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String hashedPassword = encoder.encode(rawPassword);

        System.out.println(hashedPassword);
    }
}