package com.duoc.backend.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Verificamos si la tabla está vacía para no duplicar datos al iniciar
            if (userRepository.count() == 0) {
                
                User user1 = new User();
                user1.setUsername("veterinario");
                user1.setEmail("veterinario@unidosporlosanimales.cl");
                user1.setPassword(passwordEncoder.encode("vet123"));
                userRepository.save(user1);

                User user2 = new User();
                user2.setUsername("asistente");
                user2.setEmail("asistente@unidosporlosanimales.cl");
                user2.setPassword(passwordEncoder.encode("asis123"));
                userRepository.save(user2);

                User user3 = new User();
                user3.setUsername("cliente");
                user3.setEmail("cliente@unidosporlosanimales.cl");
                user3.setPassword(passwordEncoder.encode("cliente123"));
                userRepository.save(user3);
            }
        };
    }
}