package com.project.MovieTicket.Controller;

import com.project.MovieTicket.Model.Movie;
import com.project.MovieTicket.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    // หน้าแรก
    @RequestMapping("/home")
        public String home(Model model) {
            // ดึงภาพยนตร์สุ่ม 3 เรื่อง
            List<Movie> randomMovies = movieService.getRandomMovies(3);

            // ส่งข้อมูลภาพยนตร์ไปยัง view
            model.addAttribute("movies", randomMovies);

        return "home"; // หน้า home.jsp
    }

    // แสดงรายการภาพยนตร์ทั้งหมด หรือค้นหา
    @RequestMapping("/movies")
    public String showMoviesPage(@RequestParam(value = "query", required = false) String query, Model model) {
        List<Movie> movies;

        if (query != null && !query.isEmpty()) {
            movies = movieService.searchMoviesByTitle(query); // ค้นหาตามชื่อ
        } else {
            movies = movieService.getAllMovies(); // ดึงรายการทั้งหมด
        }

        model.addAttribute("movies", movies);
        model.addAttribute("searchQuery", query); // ส่งค่าคำค้นหาไปยัง View
        return "movies";  // หน้า movies.html หรือ movies.jsp
    }

    // แสดงรายละเอียดของภาพยนตร์ในหน้า Cinema

    @GetMapping("/cinema")
    public String cinemaPage(Model model) {
        model.addAttribute("movieName");
        return "cinema"; // ชื่อไฟล์ cinema.jsp
    }
    // หน้าโปรโมชั่น
    @RequestMapping("/promotion")
    public String showPromotionPage() {
        return "promotion"; // หน้า promotion.jsp หรือ promotion.html
    }

    // หน้าเลือกที่นั่ง
    @RequestMapping("/seat")
    public String showSeatPage() {
        return "seat"; // หน้า seat.jsp หรือ seat.html
    }

    // หน้าซื้อบัตร
    @RequestMapping("/buyticket")
    public String showBuyticketPage() {
        return "buyticket"; // หน้า buyticket.jsp หรือ buyticket.html
    }

    // หน้าข้อมูลโปรไฟล์ผู้ใช้งาน
    @RequestMapping("/profile")
    public String showProfilePage() {
        return "profile"; // หน้า profile.jsp หรือ profile.html
    }
}
