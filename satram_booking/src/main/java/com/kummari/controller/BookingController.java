package com.kummari.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kummari.model.Booking;
import com.kummari.model.Room;
import com.kummari.model.User;
import com.kummari.service.BookingService;
import com.kummari.service.RoomService;
import com.kummari.service.UserService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;
    private final UserService userService;
    private final RoomService roomService;

    public BookingController(BookingService bookingService, UserService userService, RoomService roomService) {
        this.bookingService = bookingService;
        this.userService = userService;
        this.roomService = roomService;
    }

    @PostMapping
    public String bookRoom(@RequestParam Long userId,
                           @RequestParam Long roomId,
                           @RequestBody Booking booking) {

        User user = userService.getUser(userId);
        Room room = roomService.getRoomById(roomId);

        if (user == null) return "Invalid user";
        if (room == null) return "Invalid room";

        return bookingService.bookRoom(user, room, booking);
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getUserBookings(@PathVariable Long userId) {
        return bookingService.getUserBookings(userId);
    }
}