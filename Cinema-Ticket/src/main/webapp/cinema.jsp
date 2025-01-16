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



    <!-- Content -->
    <%
    String movieName = request.getParameter("movieName");
    %>
        <h2 class="region-title">BY LOCATION</h2>
    <div class="location-container">
        <!-- ภาคกลาง -->
        <div class="location-column">
            <h3>ภาคกลาง</h3>
            <ul class="cinema-list">
                <li>
                    <img src="vl_white.png" alt="VL Cinema Logo">
                    <a href="seat.jsp?movieName=<%= movieName %>&cinemaName=กรุงเทพ" class="location-link">
                    <span>กรุงเทพ</span>
                    </a>
                    <span class="star">★</span>
                </li>
                <!-- เพิ่มสาขาอื่นๆ -->
            </ul>
        </div>

        <!-- ภาคเหนือ -->
        <div class="location-column">
            <h3>ภาคเหนือ</h3>
            <ul class="cinema-list">
                <li>
                    <img src="vl_white.png" alt="VL Cinema Logo">
                    <a href="seat.jsp?movieName=<%= movieName %>&cinemaName=เชียงใหม่" class="location-link">
                    <span>เชียงใหม่</span>
                    </a>
                    <span class="star">★</span>
                </li>
                <!-- เพิ่มสาขาอื่นๆ -->
            </ul>
        </div>

        <!-- ภาคตะวันออกเฉียงเหนือ -->
        <div class="location-column">
            <h3>ภาคตะวันออกเฉียงเหนือ</h3>
            <ul class="cinema-list">
                <li>
                    <img src="vl_white.png" alt="VL Cinema Logo">
                    <a href="seat.jsp?movieName=<%= movieName %>&cinemaName=อุดรธานี" class="location-link">
                    <span>อุดรธานี</span>
                    </a>
                    <span class="star">★</span>
                </li>
                <!-- เพิ่มสาขาอื่นๆ -->
            </ul>
        </div>

        <!-- ภาคใต้ -->
        <div class="location-column">
            <h3>ภาคใต้</h3>
            <ul class="cinema-list">
                <li>
                    <img src="vl_white.png" alt="VL Cinema Logo">
                    <a href="seat.jsp?movieName=<%= movieName %>&cinemaName=ภูเก็ต" class="location-link">
                    <span>ภูเก็ต</span>
                    </a>
                    <span class="star">★</span>
                </li>
                <!-- เพิ่มสาขาอื่นๆ -->
            </ul>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
