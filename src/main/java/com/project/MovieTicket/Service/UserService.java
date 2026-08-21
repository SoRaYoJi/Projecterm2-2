package com.project.MovieTicket.Service;

import com.project.MovieTicket.Entity.User;
import com.project.MovieTicket.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ฟังก์ชันสมัครสมาชิก
    public String registerUser(String username, String password) {
        // เช็คว่ามี Username อยู่แล้วหรือไม่
        if (userRepository.findByUsername(username).isPresent()) {
            return "ชื่อผู้ใช้นี้มีอยู่แล้ว!";
        }

        // สร้าง User และบันทึกลงฐานข้อมูล โดยเข้ารหัสรหัสผ่านด้วย BCrypt
        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(username, encodedPassword);
        userRepository.save(user);

        return "สมัครสมาชิกสำเร็จ!";
    }
}




