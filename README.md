# 🎬 VL Cineplex — Movie Ticket Booking & Management System

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=flat-square&logo=springboot)
![Spring Security](https://img.shields.io/badge/Spring%20Security-BCrypt-blue?style=flat-square&logo=springsecurity)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=flat-square&logo=mysql)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-Template-green?style=flat-square)
![License](https://img.shields.io/badge/License-MIT-lightgrey?style=flat-square)

เว็บแอปพลิเคชันระบบจองตั๋วภาพยนตร์แบบ Full-Stack พัฒนาด้วย **Java Spring Boot 3**, **Thymeleaf**, **Spring Security**, **Spring Data JPA** และ **MySQL** ออกแบบด้วยดีไซน์ธีมมืดระดับพรีเมียม (Dark Cineplex Theme) ครอบคลุมทั้งระบบการจองตั๋วฝั่งลูกค้าโดยไม่ต้องล็อกอิน และระบบจัดการข้อมูลฝั่งผู้ดูแลระบบ (Admin Dashboard)

---

## 🌟 ฟีเจอร์เด่น (Key Features)

### 🎟️ สำหรับลูกค้า (Customer Experience)
- **Guest Checkout**: จองตั๋วหนังได้ทันทีโดยไม่ต้องผ่านการสมัครสมาชิก/ล็อกอิน
- **Interactive Seat Map**: แผนผังเลือกที่นั่งโต้ตอบทันที พร้อมคำนวณราคายอดรวมอัตโนมัติ
- **Movie Catalog & Filters**: ค้นหาภาพยนตร์ตามชื่อเรื่อง และกรองตามหมวดหมู่ (Action, Sci-Fi, Animation, ฯลฯ)
- **Movie Details**: แสดงข้อมูลครบถ้วน ทั้งเรื่องย่อ, ผู้กำกับ, นักแสดงนำ, คะแนน ⭐, ตัวอย่างหนัง, และรอบฉายแยกตามสาขา
- **Instant Receipt & Ticket**: ออกใบเสร็จรหัสจอง unique พร้อม QR Code และฟังก์ชันพิมพ์ใบเสร็จ
- **My Tickets Lookup**: ระบบค้นหาตั๋วที่เคยจองไว้ด้วยรหัสจอง หรือ อีเมลที่หน้า `/my-tickets`

### ⚙️ สำหรับผู้ดูแลระบบ (Admin Dashboard)
- **Secured Authentication**: ระบบล็อกอินฝั่ง Admin เข้ารหัสด้วย BCrypt และควบคุมสิทธิ์ด้วย Spring Security
- **Analytics Overview**: หน้าสรุปสถิติจำนวนภาพยนตร์, ยอดการจอง, โปรโมชั่นที่เปิดใช้งาน และตารางการจองล่าสุด
- **Movie Management (CRUD)**: เพิ่ม/แก้ไข/ลบ ข้อมูลภาพยนตร์ พร้อมระบบดูตัวอย่างโปสเตอร์ (Live Preview)
- **Showtime Management (CRUD)**: เพิ่ม/แก้ไข/ลบ รอบฉาย แยกตามสาขา, โรง (Hall), วันเวลา, ราคา และที่นั่ง
- **Promotion Management (CRUD)**: เพิ่ม/แก้ไข/ลบ โปรโมชั่น, ภาพแบนเนอร์ และส่วนลด %

---

## 🛠️ Tech Stack & Architecture

- **Backend**: Java 17, Spring Boot 3, Spring Data JPA, Spring Security (BCrypt)
- **Frontend**: HTML5, Vanilla CSS3 (Dark Cineplex Theme, Glassmorphism, CSS Variables), JavaScript (ES6+), Thymeleaf Engine
- **Database**: MySQL 8.0
- **Build Tool**: Maven

```
[ Browser (Client) ] ──► [ Spring MVC Controller ] ──► [ Service Layer ] ──► [ Spring Data JPA ] ──► [ MySQL DB ]
                               │
                               ▼
                       [ Thymeleaf Engine ] ──► [ Dark Mode HTML/CSS ]
```

---

## 🗄️ โครงสร้างฐานข้อมูล (Database Schema)

```
MOVIES ───< SHOWTIMES ───< BOOKINGS
USERS (Admin Only)
PROMOTIONS
```

รายละเอียดตารางฐานข้อมูลและ Seed Data สามารถดูได้ในไฟล์ [`database/schema.sql`](database/schema.sql)

---

## 🚀 วิธีการรันโปรเจกต์ (Getting Started)

### 1. สิ่งที่ต้องมีในเครื่อง (Prerequisites)
- **Java JDK 17** หรือสูงกว่า
- **MySQL Server** (รันอยู่ที่ `localhost:3306`)

### 2. ตั้งค่าฐานข้อมูล (Database Setup)
1. เปิด MySQL Client หรือ MySQL Workbench
2. สร้าง Database ชื่อ `movie`:
   ```sql
   CREATE DATABASE movie CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
   ```
3. รันสคริปต์สร้างตารางและใส่ข้อมูลตัวอย่างจากไฟล์ [`database/schema.sql`](database/schema.sql)
4. ตรวจสอบ Username / Password ในไฟล์ [`src/main/resources/application.properties`](src/main/resources/application.properties) ให้ตรงกับเครื่องของคุณ

### 3. รันแอปพลิเคชัน (Run Application)

```powershell
# บน Windows
.\mvnw.cmd spring-boot:run

# บน Linux / macOS
./mvnw spring-boot:run
```

เปิดเบราว์เซอร์ไปที่: 👉 **http://localhost:8080**

---

## 🔐 บัญชีเข้าใช้งาน Admin (Default Credentials)

- **Admin Login URL**: `http://localhost:8080/admin/login`
- **Username**: `admin`
- **Password**: `admin123`

---

## 📝 License

โปรเจกต์นี้จัดทำขึ้นเพื่อการศึกษาและการสะสมผลงาน (Portfolio)
