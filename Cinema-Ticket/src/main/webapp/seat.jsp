<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="th">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>VL Cineplex</title>
    <link rel="stylesheet" href="css/seat.css">
</head>
<body>
 <%
        String movieName = request.getParameter("movieName");
        String cinemaName = request.getParameter("cinemaName");
    %>
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
            <div class="lang-switch">
                <a href="#th">TH</a> | <a href="#en">EN</a>
            </div>
            <div class="user-icon">
                <img src="user_icon.png" alt="User Icon">
            </div>
        </div>
    </header>

    <main>
    <h1><%= movieName != null ? movieName : "ไม่ระบุชื่อหนัง" %></h1>
        <h2>สาขา: <%= cinemaName != null ? cinemaName : "ไม่ระบุชื่อสาขา" %></h2>
        <!-- หน้าจอ -->
        <div class="screen">SCREEN</div>

        <!-- ที่นั่ง -->
        <div class="seating-area">
            <!-- แถวที่ 1 -->
            <div class="row">
            <div class="row-label">A</div>
                <% for (int i = 0; i < 10; i++) { %>
                <div class="seat deluxe"><img src="chair.png" alt="Deluxe Seat"></div>
                <% } %>
                <div class="row-label">A</div>
            </div>
            <!-- แถวที่ 2 -->
            <div class="row">
            <div class="row-label">B</div>
                <% for (int i = 0; i < 10; i++) { %>
                <div class="seat deluxe"><img src="chair.png" alt="Deluxe Seat"></div>
                <% } %>
                <div class="row-label">B</div>
            </div>
            <!-- แถวที่ 3 -->
            <div class="row">
            <div class="row-label">C</div>
                <% for (int i = 0; i < 10; i++) { %>
                <div class="seat premium"><img src="chair.png" alt="Premium Seat"></div>
                <% } %>
                 <div class="row-label">C</div>
            </div>
            <!-- แถวที่ 4 -->
            <div class="row">
            <div class="row-label">D</div>
                <% for (int i = 0; i < 10; i++) { %>
                <div class="seat premium"><img src="chair.png" alt="Premium Seat"></div>
                <% } %>
                 <div class="row-label">D</div>
            </div>
            <!-- แถวที่ 5 -->
            <div class="row">
            <div class="row-label">E</div>
                <% for (int i = 0; i < 10; i++) { %>
                <div class="seat premium"><img src="chair.png" alt="Premium Seat"></div>
                <% } %>
                 <div class="row-label">E</div>
            </div>
            <!-- แถวที่ 6 -->
            <div class="row">
            <div class="row-label">F</div>
                <% for (int i = 0; i < 10; i++) { %>
                <div class="seat premium"><img src="seat.png" alt="Premium Seat"></div>
                <% } %>
                <div class="row-label">F</div>
            </div>
            <!-- แถวที่ 7 -->
            <div class="row">
            <div class="row-label">G</div>
                <% for (int i = 0; i < 10; i++) { %>
                <div class="seat premium"><img src="vipseat.png" alt="Premium Seat"></div>
                <% } %>
                <div class="row-label">G</div>
            </div>
        </div>

        <!-- ราคา -->
        <div class="pricing">
            <div>
                <div class="box deluxe"></div> Deluxe 400 บาท
            </div>
            <div>
                <div class="box premium"></div> Premium 450 บาท
            </div>
            <div>
                <div class="box vip"></div> VIP 500 บาท
            </div>
        </div>
    </main>
</body>
</html>
