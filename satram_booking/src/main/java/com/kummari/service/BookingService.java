package com.kummari.service;

import org.springframework.stereotype.Service;

import com.kummari.model.Booking;
import com.kummari.model.Room;
import com.kummari.model.User;
import com.kummari.repository.BookingRepository;
import com.kummari.repository.RoomRepository;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;

    public BookingService(BookingRepository bookingRepository, RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
    }

    public String bookRoom(User user, Room room, Booking booking) {
        if (!room.getAvailable()) {
            return "Room not available";
        }
        booking.setUser(user);
        booking.setRoom(room);

        room.setAvailable(false); // mark room as booked
        roomRepository.save(room);
        bookingRepository.save(booking);
        return "Booking successful";
    }

    public List<Booking> getUserBookings(Long userId) {
        return bookingRepository.findByUserId(userId);
    }
}