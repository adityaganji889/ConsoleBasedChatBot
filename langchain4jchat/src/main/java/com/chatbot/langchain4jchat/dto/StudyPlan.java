package com.chatbot.langchain4jchat.dto;

import java.util.List;

import dev.langchain4j.model.output.structured.Description;

public record StudyPlan(
	@Description("Title of the study plan")
	String planTitle,
	@Description("Number of days in the study plan")
	Integer numberOfDays,
	Integer hoursPerDay,
	List<DayPlan> dayPlans
) {	
	
}
