package com.kummari.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kummari.mapper.UserMapper;
import com.kummari.mapper.RoomMapper;
import com.kummari.mapper.BookingMapper;

@Component
public class DBInitializer implements CommandLineRunner {

    private final UserMapper userMapper;
    private final RoomMapper roomMapper;
    private final BookingMapper bookingMapper;

    public DBInitializer(UserMapper userMapper, RoomMapper roomMapper, BookingMapper bookingMapper) {
        this.userMapper = userMapper;
        this.roomMapper = roomMapper;
        this.bookingMapper = bookingMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        userMapper.createTable();
        roomMapper.createTable();
        bookingMapper.createTable();
        System.out.println("✅ All tables created successfully!");
    }
}
