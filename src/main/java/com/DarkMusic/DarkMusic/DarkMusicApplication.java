package com.DarkMusic.DarkMusic;

import com.DarkMusic.DarkMusic.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DarkMusicApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DarkMusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World");
		Principal.Exibirmenu();
	}
}
