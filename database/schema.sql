CREATE TABLE movie (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    synopsis TEXT,
    director VARCHAR(255),
    cast TEXT,
    poster_url VARCHAR(255),
    release_date DATE,
    duration INT,
    genre VARCHAR(100),
    rating DECIMAL(3, 1),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
