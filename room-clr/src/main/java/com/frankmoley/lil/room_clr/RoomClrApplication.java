package com.frankmoley.lil.room_clr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
public class RoomClrApplication {
	@Value("${limit}")
	int initialValue;

	public static void main(String[] args) {
		SpringApplication.run(RoomClrApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return args -> {
			int limit = 100;

			try {
				if (args.length > 0) {
					limit = Integer.parseInt(args[0]);
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input");
			}

			System.out.println("Running FizzBuzz up to: " + limit);
			for (int i = 1; i <= limit; i++) {
				if (i % 3 == 0 && i % 5 == 0) {
					System.out.println("FizzBuzz");
				} else if (i % 3 == 0) {
					System.out.println("Fizz");
				} else if (i % 5 == 0) {
					System.out.println("Buzz");
				} else {
					System.out.println(i);
				}
			}
		};
	}

}
