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
        <div class="promotion-title">Great Value Promotion</div>
        <div class="promotion-image">
          <!-- รูปภาพจะแสดงและเปลี่ยนที่นี่ -->
          <img id="slideshow-image" src="./images/promotion/p1.jpg" alt="Promotion Slide" />

          <!-- ลิงก์ไปยังไฟล์ promotion.js -->
          <script src="css/js/promotion.js"></script>
       </div>

    </main>

</body>
</html>