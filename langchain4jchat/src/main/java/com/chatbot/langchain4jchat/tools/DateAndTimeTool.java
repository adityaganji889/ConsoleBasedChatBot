package com.chatbot.langchain4jchat.tools;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import dev.langchain4j.agent.tool.Tool;

public class DateAndTimeTool {

	@Tool
	public String getDateAndTime() {
		System.out.println("Fetching current date and time...");
		LocalDateTime ldt = LocalDateTime.now();
//		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY HH12:MM:SS");
//		String fetchedDateAndTime = sdf.format(ldt);
		DateTimeFormatter formatter =
	            DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a");
	    String fetchedDateAndTime = ldt.format(formatter);
		return fetchedDateAndTime;
	}
	
//	@Tool
//	public String getTime() {
//		System.out.println("Fetching current time...");
//		LocalDateTime ldt = LocalDateTime.now();
//		SimpleDateFormat sdf = new SimpleDateFormat("HH12:MM:SS");
//		String fetchedTime = sdf.format(ldt);
//		return fetchedTime;
//	}
}
