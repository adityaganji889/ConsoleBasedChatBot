package com.chatbot.langchain4jchat.service;

import com.chatbot.langchain4jchat.config.LoadProperties;
import com.chatbot.langchain4jchat.dto.StudyPlan;

//import dev.langchain4j.data.message.AiMessage;
//import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
//import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;

public class ChatHelper {
	
	private static LoadProperties p = new LoadProperties();

	public static String getResponse(String input) {
		ChatModel chatModel = OpenAiChatModel.builder()
				                             .apiKey(p.getApiKey())
				                             .modelName(p.getModelName())
				                             .temperature(p.getTemperature())
				                             .build();
//		AiMessage aiMessage = new AiMessage("Hello, how can I help you?");
//		UserMessage userInputMessage = UserMessage.from(input);
//		
//		ChatResponse chatResponse = chatModel.chat(aiMessage,userInputMessage);
		
		BotAssistant botAssistant = AiServices.create(BotAssistant.class, chatModel);
		String chatResponse = botAssistant.chatWithBot(input);
		return chatResponse;
//		return chatResponse.aiMessage().text();
	}
	
	public static StudyPlan prepareStudyPlanner(String topic) {
		ChatModel chatModel = OpenAiChatModel.builder()
                .apiKey(p.getApiKey())
                .modelName(p.getModelName())
                .temperature(p.getTemperature())
                .build();	
		StudyPlanner studyPlanner = AiServices.create(StudyPlanner.class, chatModel);
		StudyPlan studyPlan = studyPlanner.getStudyPlan(topic);
		return studyPlan;
	}
}
