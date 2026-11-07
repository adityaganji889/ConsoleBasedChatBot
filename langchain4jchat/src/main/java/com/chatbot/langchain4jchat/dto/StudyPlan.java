package com.chatbot.langchain4jchat.dto;

import java.util.List;

public record StudyPlan(
	String planTitle,
	Integer numberOfDays,
	Integer hoursPerDay,
	List<DayPlan> dayPlans
) {	
	
}
