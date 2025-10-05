package com.project.MovieTicket.Service;

import com.project.MovieTicket.Entity.User;
import com.project.MovieTicket.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // ค้นหาผู้ใช้จากฐานข้อมูล
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // ใช้ข้อมูลผู้ใช้โดยไม่เข้ารหัสรหัสผ่าน
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())  // ไม่เข้ารหัสรหัสผ่าน
                .build();
    }
}
