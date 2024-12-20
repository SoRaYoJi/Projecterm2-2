<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="th">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>VL Cineplex</title>
    <link rel="stylesheet" href="css/cinema.css">
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
            <div class="movie">
                <img src="images/dune.jpg" alt="Dune">
                <h2>Dune: Part Two</h2>
            </div>
            <div class="movie">
                <img src="images/ghostbusters.jpg" alt="Ghostbusters">
                <h2>Ghostbusters: Frozen Empire</h2>
            </div>
            <div class="movie">
                <img src="images/the-end.jpg" alt="The End">
                <h2>The End We Start From</h2>
            </div>
        </section>
    </main>

    <footer>
        <p>&copy; 2024 VL Cineplex</p>
    </footer>
</body>
</html>