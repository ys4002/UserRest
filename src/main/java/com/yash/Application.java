package com.yash;

import java.util.Timer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.yash.support.UpdateNewsTimer;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private UpdateNewsTimer updateNewsTimer;

	/**
	 * Timer task to be started when the application starts
	 */
	@PostConstruct
	@Transactional
	private void init() {
		Timer time = new Timer(); // Instantiate Timer Object
		// Instantiate SheduledTask class

		// timer for 5 minutes
		time.schedule(updateNewsTimer, 0, 300000);
	}

}
