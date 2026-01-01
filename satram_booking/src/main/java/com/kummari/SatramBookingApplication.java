package com.kummari;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kummari.mapper")
public class SatramBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SatramBookingApplication.class, args);
	}

}
