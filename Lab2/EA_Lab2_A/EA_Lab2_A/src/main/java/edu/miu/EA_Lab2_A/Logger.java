package edu.miu.EA_Lab2_A;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class Logger implements ILogger{

	public void log(String logstring) {
		System.out.println("Logging "+LocalDateTime.now()+" "+logstring);		
	}

}
