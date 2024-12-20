<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Movies - VL Cineplex</title>
    <link rel="stylesheet" href="css/promotion.css">
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
                <li><a href="cinema.jsp">Cinema</a></li>
                <li><a href="promotion.jsp">Promotion</a></li>
            </ul>
            <div class="lang-switch">
                <a href="promotion.jsp">EN</a> | <a href="promotionthai.jsp">TH</a>
            </div>
        </nav>
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
