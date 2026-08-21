-- ============================================================
-- VL Cineplex Database Schema
-- ============================================================

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS bookings;
DROP TABLE IF EXISTS showtimes;
DROP TABLE IF EXISTS promotions;
DROP TABLE IF EXISTS movies;
DROP TABLE IF EXISTS users;
SET FOREIGN_KEY_CHECKS = 1;

-- 1. Admin Users
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    role VARCHAR(50) DEFAULT 'ROLE_USER',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 2. Movies
CREATE TABLE movies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    synopsis TEXT,
    director VARCHAR(255),
    cast_list TEXT,
    poster_url VARCHAR(500),
    trailer_url VARCHAR(500),
    genre VARCHAR(100),
    language VARCHAR(50) DEFAULT 'TH',
    rating DECIMAL(3,1) DEFAULT 0.0,
    duration_minutes INT DEFAULT 120,
    release_date DATE,
    is_now_showing BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 3. Showtimes
CREATE TABLE showtimes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    movie_id INT NOT NULL,
    cinema VARCHAR(100) NOT NULL,
    show_date DATE NOT NULL,
    show_time VARCHAR(10) NOT NULL,
    hall VARCHAR(50) DEFAULT 'Hall 1',
    price DECIMAL(8,2) DEFAULT 250.00,
    total_seats INT DEFAULT 60,
    available_seats INT DEFAULT 60,
    FOREIGN KEY (movie_id) REFERENCES movies(id) ON DELETE CASCADE
);

-- 4. Promotions
CREATE TABLE promotions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    image_url VARCHAR(500),
    discount_percent INT DEFAULT 0,
    valid_from DATE,
    valid_to DATE,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 5. Bookings (no login required)
CREATE TABLE bookings (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    booking_code VARCHAR(20) NOT NULL UNIQUE,
    movie_name VARCHAR(255) NOT NULL,
    cinema VARCHAR(100),
    show_date VARCHAR(50),
    show_time VARCHAR(50),
    hall VARCHAR(50),
    seats_count INT DEFAULT 1,
    seat_numbers VARCHAR(255),
    price_per_seat DECIMAL(8,2) DEFAULT 250.00,
    total_price DECIMAL(10,2),
    customer_name VARCHAR(100),
    customer_email VARCHAR(255),
    customer_phone VARCHAR(20),
    payment_method VARCHAR(50),
    status VARCHAR(50) DEFAULT 'CONFIRMED',
    booking_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ============================================================
-- Seed Data
-- ============================================================

-- Admin user (password: admin123 BCrypt)
INSERT INTO users (username, password, email, role) VALUES
('admin', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iAt6Zz5e', 'admin@vlcineplex.com', 'ROLE_ADMIN');

-- Sample Movies
INSERT INTO movies (title, synopsis, director, cast_list, poster_url, genre, language, rating, duration_minutes, release_date, is_now_showing) VALUES
('DUNE: PART TWO',
 'Paul Atreides เดินทางร่วมกับ Chani และชาว Fremen เพื่อแก้แค้นผู้สมรู้ร่วมคิดที่ทำลายครอบครัวของเขา ในขณะที่เผชิญหน้ากับชะตากรรมที่ยิ่งใหญ่',
 'Denis Villeneuve',
 'Timothée Chalamet, Zendaya, Rebecca Ferguson, Josh Brolin',
 'https://image.tmdb.org/t/p/w500/8b8R8l88Qje9dn9OE8PY05Nxl1X.jpg',
 'Sci-Fi / Adventure', 'EN', 4.9, 166, '2024-02-29', TRUE),

('GHOSTBUSTERS: FROZEN EMPIRE',
 'ครอบครัว Spengler กลับมายังเมืองนิวยอร์กอีกครั้ง เพื่อเผชิญหน้ากับภัยใหม่ที่อาจทำให้โลกกลายเป็นน้ำแข็ง',
 'Gil Kenan',
 'Paul Rudd, Carrie Coon, Finn Wolfhard, Mckenna Grace',
 'https://image.tmdb.org/t/p/w500/e1s47OwP0JPbFKxDFWRbYkNkxV6.jpg',
 'Action / Comedy', 'EN', 4.5, 115, '2024-03-21', TRUE),

('GODZILLA X KONG: THE NEW EMPIRE',
 'ไททันสองตัวอย่าง Godzilla และ Kong ปะทะกันในสมรภูมิอันยิ่งใหญ่ ขณะที่มนุษย์พยายามค้นหาต้นกำเนิดของพวกมัน',
 'Adam Wingard',
 'Rebecca Hall, Brian Tyree Henry, Dan Stevens',
 'https://image.tmdb.org/t/p/w500/kowFQMHM9MBKbxME33P4VMDY4yO.jpg',
 'Action / Sci-Fi', 'EN', 4.6, 115, '2024-03-28', TRUE),

('INSIDE OUT 2',
 'Riley วัยรุ่นกำลังเข้าสู่วัยมัธยมปลาย อารมณ์ใหม่ๆ อย่าง Anxiety เริ่มบุกรุกเข้าไปในศูนย์กลางอารมณ์ของเธอ',
 'Kelsey Mann',
 'Amy Poehler, Maya Hawke, Kensington Tallman',
 'https://image.tmdb.org/t/p/w500/vpnVM9B6NMmQpWeZvzLvDESb2QY.jpg',
 'Animation / Family', 'EN', 4.8, 100, '2024-06-14', TRUE);

-- Sample Showtimes
INSERT INTO showtimes (movie_id, cinema, show_date, show_time, hall, price, total_seats, available_seats) VALUES
(1, 'VL Cineplex กรุงเทพ', CURDATE(), '12:00', 'Hall A', 280.00, 80, 80),
(1, 'VL Cineplex กรุงเทพ', CURDATE(), '15:30', 'Hall A', 280.00, 80, 60),
(1, 'VL Cineplex กรุงเทพ', CURDATE(), '19:00', 'Hall B', 280.00, 80, 45),
(1, 'VL Cineplex เชียงใหม่', CURDATE(), '13:00', 'Hall 1', 260.00, 60, 60),
(2, 'VL Cineplex กรุงเทพ', CURDATE(), '11:00', 'Hall C', 250.00, 80, 80),
(2, 'VL Cineplex กรุงเทพ', CURDATE(), '14:30', 'Hall C', 250.00, 80, 72),
(2, 'VL Cineplex อุดรธานี', CURDATE(), '16:00', 'Hall 1', 240.00, 60, 60),
(3, 'VL Cineplex กรุงเทพ', CURDATE(), '10:00', 'Hall D', 270.00, 80, 80),
(3, 'VL Cineplex กรุงเทพ', CURDATE(), '18:00', 'Hall D', 270.00, 80, 55),
(4, 'VL Cineplex กรุงเทพ', CURDATE(), '13:00', 'Hall E', 260.00, 80, 80),
(4, 'VL Cineplex ภูเก็ต', CURDATE(), '15:00', 'Hall 1', 250.00, 60, 60);

-- Sample Promotions
INSERT INTO promotions (title, description, image_url, discount_percent, valid_from, valid_to, is_active) VALUES
('นักศึกษาลด 20%', 'นักศึกษาทุกมหาวิทยาลัยรับส่วนลด 20% เพียงแสดงบัตรนักศึกษา', 'https://images.unsplash.com/photo-1489599849927-2ee91cede3ba?w=800', 20, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 60 DAY), TRUE),
('วันอังคาร ลด 50 บาท', 'ทุกวันอังคาร ซื้อตั๋วราคาพิเศษ ลด 50 บาท ทุกรอบ', 'https://images.unsplash.com/photo-1524985069026-dd778a71c7b4?w=800', 0, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 180 DAY), TRUE),
('คู่รักสุดพิเศษ 2 ที่นั่ง 450 บาท', 'ซื้อ 2 ที่นั่งในราคาพิเศษ 450 บาท (ปกติ 500 บาท)', 'https://images.unsplash.com/photo-1542204165-65bf26472b9b?w=800', 10, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 30 DAY), TRUE);
