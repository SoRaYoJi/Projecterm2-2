<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>VL Cineplex</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <header>
        <h1>VL CINEPLEX</h1>
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
