package com.chatbot.langchain4jchat.service;

import com.chatbot.langchain4jchat.dto.StudyPlan;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface StudyPlanner {

	@UserMessage("""
			 You are an expert in planning the study plan for a student.
			 Create a useful plan for given topic:
			 {{topic}}
			""")
    StudyPlan getStudyPlan(@V("topic") String topic);
}
