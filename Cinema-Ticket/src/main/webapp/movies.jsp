<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="th">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>VL Cineplex</title>
    <link rel="stylesheet" href="css/movies.css">
</head>
<body>
    <header>
    <!-- โลโก้ -->
    <div class="logo-container">
        <img class="logo" src="vl_cineplex.png" alt="VL Cineplex">
    </div>

    <!-- เมนูนำทาง -->
    <nav class="nav-menu">
        <ul>
            <li><a href="index.jsp">Home page</a></li>
                <li><a href="movies.jsp">Movies</a></li>
                <li><a href="cinema.jsp">Cinema</a></li>
                <li><a href="promotion.jsp">Promotion</a></li>
        </ul>
    </nav>

    <!-- เมนูด้านขวา -->
    <div class="right-menu">
        <!-- ภาษา -->
        <div class="lang-switch">
            <a href="#th">TH</a> | <a href="#en">EN</a>
        </div>
        <!-- ไอคอนผู้ใช้ -->
        <div class="user-icon">
            <img src="user_icon.png" alt="User Icon">
        </div>
    </div>
</header>


    <main>
        <section class="movies">
            <h2>เลือกหนัง</h2>

            <!-- Month Selector -->
            <div class="month-selector">
                <label for="month">เลือกเดือน: </label>
                <select id="month">
                    <!-- 2023 -->
                    <option value="jan-2023">มกราคม 2023</option>
                    <option value="feb-2023">กุมภาพันธ์ 2023</option>
                    <option value="mar-2023">มีนาคม 2023</option>
                    <option value="apr-2023">เมษายน 2023</option>
                    <option value="may-2023">พฤษภาคม 2023</option>
                    <option value="jun-2023">มิถุนายน 2023</option>
                    <option value="jul-2023">กรกฎาคม 2023</option>
                    <option value="aug-2023">สิงหาคม 2023</option>
                    <option value="sep-2023">กันยายน 2023</option>
                    <option value="oct-2023">ตุลาคม 2023</option>
                    <option value="nov-2023">พฤศจิกายน 2023</option>
                    <option value="dec-2023">ธันวาคม 2023</option>
                    
                    <!-- 2024 -->
                    <option value="jan-2024">มกราคม 2024</option>
                    <option value="feb-2024">กุมภาพันธ์ 2024</option>
                    <option value="mar-2024">มีนาคม 2024</option>
                    <option value="apr-2024">เมษายน 2024</option>
                    <option value="may-2024">พฤษภาคม 2024</option>
                    <option value="jun-2024">มิถุนายน 2024</option>
                    <option value="jul-2024">กรกฎาคม 2024</option>
                    <option value="aug-2024">สิงหาคม 2024</option>
                    <option value="sep-2024">กันยายน 2024</option>
                    <option value="oct-2024">ตุลาคม 2024</option>
                    <option value="nov-2024">พฤศจิกายน 2024</option>
                    <option value="dec-2024">ธันวาคม 2024</option>
                </select>
            </div>

            <!-- Search Bar -->
            <div class="search-bar">
                <input type="text" placeholder="ค้นหาหนัง...">
            </div>

            <!-- Movie List -->
            <div class="movie-list">
                <div class="movie-card" onclick="window.location.href='cinema.jsp';">
                    <img src="images/ghostbusters.jpg" alt="Ghostbusters">
                    <h3>GHOSTBUSTERS</h3>
                    <p>9 NOV 2024</p>
                    <span>120 นาที</span>
                </div>

                <div class="movie-card" onclick="window.location.href='cinema.jsp';">
                    <img src="images/dune.jpg" alt="Dune">
                    <h3>DUNE</h3>
                    <p>9 NOV 2024</p>
                    <span>130 นาที</span>
                </div>

                <div class="movie-card" onclick="window.location.href='cinema.jsp';">
                    <img src="images/the-end.jpg" alt="The End">
                    <h3>THE END</h3>
                    <p>9 NOV 2024</p>
                    <span>141 นาที</span>
                </div>

                <div class="movie-card" onclick="window.location.href='cinema.jsp';">
                    <img src="images/The Con-Heartist.jpg" alt="The Con-Heartist">
                    <h3>The Con-Heartist</h3>
                    <p>10 NOV 2024</p>
                    <span>118 นาที</span>
                </div>

                <div class="movie-card" onclick="window.location.href='cinema.jsp';">
                    <img src="images/พี่นาค 3.jpg" alt="พี่นาค 3">
                    <h3>พี่นาค 3</h3>
                    <p>10 NOV 2024</p>
                    <span>120 นาที</span>
                </div>

                <div class="movie-card" onclick="window.location.href='cinema.jsp';">
                    <img src="images/ขุนพันธ์-ภาค-3.jpg" alt="ขุนพันธ์ 3">
                    <h3>ขุนพันธ์ 3</h3>
                    <p>10 NOV 2024</p>
                    <span>120 นาที</span>
                </div>
            </div>

            <!-- Pagination -->
            <div class="pagination">
                <a href="#">« Previous</a>
                <a href="#">1</a>
                <a href="#">2</a>
                <a href="#">3</a>
                <a href="#">Next »</a>
            </div>
        </section>
    </main>

    <!-- Footer -->
    <footer>
        <p>&copy; 2024 VL Cineplex</p>
    </footer>
</body>
</html>