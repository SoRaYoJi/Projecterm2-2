<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<html lang="th">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>VL Cineplex</title>
    <link th:href="@{/css/movies.css}" rel="stylesheet">
</head>
<body>
<header>
    <div class="logo-container">
        <img class="logo" th:src="@{/images/vl_cineplex.png}" alt="VL Cineplex">
    </div>
    <nav class="nav-menu">
        <ul>
            <li><a href="/home">Home page</a></li>
            <li><a href="/movies">Movies</a></li>
            <li><a href="/cinema">Cinema</a></li>
            <li><a href="/promotion">Promotion</a></li>
        </ul>
    </nav>
    <div class="right-menu">
        <div class="lang-switch">
            <a href="#th">TH</a> | <a href="#en">EN</a>
        </div>
        <div class="user-icon">
            <a href="/profile"><img th:src="@{/images/user_icon.png}" alt="User Icon"></a>
        </div>
    </div>
</header>

<main>
    <section class="movies">
        <div class="search-header">

            <div class="search-bar">
                <form action="/movies" method="get">
                    <input type="text" name="query" placeholder="ค้นหาหนัง..." th:value="${searchQuery}" required>
                    <button type="submit">ค้นหา</button>
                </form>
            </div>
        </div>
        <p th:if="${searchQuery != null}" class="search-result-msg" th:text="'ผลการค้นหาสำหรับ: ' + ${searchQuery}"></p>
        <!-- กรณีไม่มีข้อมูล -->
        <p th:if="${movies.empty}" class="no-movies">ไม่มีภาพยนตร์ที่จะแสดง</p>

        <!-- แสดงรายการภาพยนตร์ -->
        <div class="movie-list" th:if="${!movies.empty}">
            <div class="movie-card" th:each="movie : ${movies}" th:data-movie-name="${movie.title}">
                <img th:if="${movie.imagePath != null}" th:src="${movie.imagePath}" th:alt="${movie.title}">
                <p th:if="${movie.imagePath == null}">No Image Available</p>
                <h3 th:text="${movie.title}">Movie Title</h3>
                <p th:text="${#dates.format(movie.releaseDate, 'dd MMM yyyy')}">Release Date</p>
                <p th:text="'Duration: ' + ${movie.duration} + ' minutes'"></p>
            </div>
        </div>

        <!-- ปุ่ม Pagination -->
        <div class="pagination" th:if="${totalPages > 1}">
            <ul>
                <li th:each="i : ${#numbers.sequence(1, totalPages)}">
                    <a th:href="@{/movies(page=${i})}" th:text="${i}"></a>
                </li>
            </ul>
        </div>
    </section>
</main>

<footer>
    <p>&copy; 2024 VL Cineplex</p>
</footer>

<script>
    document.querySelectorAll('.movie-card').forEach(function(card) {
        card.addEventListener('click', function() {
            var movieName = card.getAttribute('data-movie-name');
            window.location.href = '/cinema?movieName=' + encodeURIComponent(movieName);
        });
    });
</script>
</body>
</html>
