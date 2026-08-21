package com.project.MovieTicket.Controller;

import com.project.MovieTicket.Entity.Booking;
import com.project.MovieTicket.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class TicketController {

    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping("/submit-booking")
    public String submitBooking(
            @RequestParam String movie,
            @RequestParam String cinema,
            @RequestParam String time,
            @RequestParam(defaultValue = "") String date,
            @RequestParam(defaultValue = "") String hall,
            @RequestParam int seats,
            @RequestParam(defaultValue = "") String seatNumbers,
            @RequestParam double price,
            @RequestParam String customerName,
            @RequestParam String customerEmail,
            @RequestParam String customerPhone,
            @RequestParam(defaultValue = "PromptPay") String paymentMethod,
            Model model
    ) {
        double totalPrice = seats * price;

        // Generate unique booking code
        String bookingCode = "VL" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        Booking booking = new Booking();
        booking.setBookingCode(bookingCode);
        booking.setMovieName(movie);
        booking.setCinema(cinema);
        booking.setShowDate(date);
        booking.setShowTime(time);
        booking.setHall(hall);
        booking.setSeatsCount(seats);
        booking.setSeatNumbers(seatNumbers);
        booking.setPricePerSeat(price);
        booking.setTotalPrice(totalPrice);
        booking.setCustomerName(customerName);
        booking.setCustomerEmail(customerEmail);
        booking.setCustomerPhone(customerPhone);
        booking.setPaymentMethod(paymentMethod);
        booking.setStatus("CONFIRMED");

        Booking saved = bookingRepository.save(booking);

        model.addAttribute("booking", saved);
        return "receipt";
    }
}
