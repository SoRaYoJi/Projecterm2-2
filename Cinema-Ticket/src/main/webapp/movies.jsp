<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Movies - VL Cineplex</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <!-- Header -->
    <header>
        <div class="logo">
            <h1>VL CINEPLEX</h1>
        </div>
        <nav>
            <ul>
               <li><a href="index.jsp">Home page</a></li>
                <li><a href="movies.jsp">Movies</a></li>
                <li><a href="promotion.jsp">Cinema</a></li>
                <li><a href="contact.jsp">Promotion</a></li>
            </ul>
            <div class="lang-switch">
                <a href="#">EN</a> | <a href="#">TH</a>
            </div>
        </nav>
    </header>

    <main>
        <section class="movies">
            <h2>กำลังฉาย</h2>
            <div class="movie-list">

                <div class="movie-card">
                    <img src="images/dune.jpg" alt="Dune">
                    <h3>J U N E</h3>
                    <p>9 NOV 2024</p>
                    <span>130 นาที</span>
                </div>

                <div class="movie-card">
                    <img src="images/ghostbusters.jpg" alt="Ghostbusters">
                    <h3>GHOSTBUSTERS</h3>
                    <p>9 NOV 2024</p>
                    <span>120 นาที</span>
                </div>

                <div class="movie-card">
                    <img src="images/ghostbusters.jpg" alt="The End">
                    <h3>THE END</h3>
                    <p>9 NOV 2024</p>
                    <span>141 นาที</span>
                </div>

                <div class="movie-card">
                    <img src="images/ghostbusters.jpg" alt="The Con-Heartist">
                    <h3>The Con-Heartist (2020)</h3>
                    <p>10 NOV 2024</p>
                    <span>118 นาที</span>
                </div>

                <div class="movie-card">
                    <img src="images/ghostbusters.jpg" alt="พี่นาค 3">
                    <h3>พี่นาค 3</h3>
                    <p>10 NOV 2024</p>
                    <span>120 นาที</span>
                </div>

                <div class="movie-card">
                    <img src="images/ghostbusters.jpg" alt="ขุนพันธ์ 3">
                    <h3>ขุนพันธ์ 3</h3>
                    <p>10 NOV 2024</p>
                    <span>120 นาที</span>
                </div>
            </div>
        </section>
    </main>

    <!-- Footer -->
    <footer>
        <p>&copy; 2024 VL Cineplex</p>
    </footer>
</body>
</html>
