# MovieTicket 🎬

ระบบจองตั๋วภาพยนตร์ (Movie Ticket Booking System) พัฒนาด้วย **Java Spring Boot**, **Thymeleaf**, **Spring Security**, และ **Spring Data JPA**.

## 📌 ฟีเจอร์หลัก (Features)
- 🏠 **Home**: หน้าหลักแสดงรายการภาพยนตร์ที่กำลังฉายและภาพยนตร์แนะนำ
- 🎬 **Movies**: ค้นหาและดูรายการภาพยนตร์ทั้งหมด
- 🎟️ **Cinema & Seat Selection**: เลือกรอบฉาย ภาพยนตร์ และผังที่นั่ง
- 💳 **Payment & Ticket**: ระบบชำระเงิน (QR PromptPay / Credit Card / KBank) และแสดงบัตรชมภาพยนตร์ (Receipt & Ticket)
- 👤 **User Profile & Auth**: ระบบ Login / Register / Profile สำหรับผู้ใช้งาน

## 🚀 วิธีการรันโปรเจกต์ (Getting Started)

### ความต้องการของระบบ (Prerequisites)
- Java 17 หรือสูงกว่า
- Maven 3.x

### การสั่งรัน (Run Application)
`ash
# บน Windows
.\mvnw.cmd spring-boot:run

# บน Linux / macOS
./mvnw spring-boot:run
`

เปิดเบราว์เซอร์ไปที่ http://localhost:8080

## 🗄️ การจัดเตรียมฐานข้อมูล (Database Setup)
สคริปต์สร้างตารางฐานข้อมูลอยู่ที่ [database/schema.sql](database/schema.sql)
