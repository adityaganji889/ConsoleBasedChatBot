package com.chatbot.langchain4jchat.service;

import com.chatbot.langchain4jchat.config.LoadProperties;
import com.chatbot.langchain4jchat.dto.StudyPlan;
import com.chatbot.langchain4jchat.tools.CalculatorTool;
import com.chatbot.langchain4jchat.tools.DateAndTimeTool;
import com.chatbot.langchain4jchat.tools.FileWriteTool;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
//import dev.langchain4j.data.message.AiMessage;
//import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.StreamingChatModel;
//import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.TokenStream;

public class ChatHelper {
	
	private static LoadProperties p = null;
	private static StreamingChatModel chatModel = null;
	private static BotAssistant botAssistant = null;
	
	static {
		LoadProperties p = new LoadProperties();
		StreamingChatModel chatModel = OpenAiStreamingChatModel.builder()  //Streaming used for non-blocking responses
                .apiKey(p.getApiKey())
                .modelName(p.getModelName())
                .temperature(p.getTemperature())
                .build();
		botAssistant = AiServices.builder(BotAssistant.class)
                .streamingChatModel(chatModel)
                .chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(10))
                .tools(
                	new CalculatorTool(), //custom tools added
                	new DateAndTimeTool(),
                	new FileWriteTool()
                )
                .build();
	}

	public static TokenStream chatWithBot(int conversationId,String input) {
//		AiMessage aiMessage = new AiMessage("Hello, how can I help you?");
//		UserMessage userInputMessage = UserMessage.from(input);
//		
//		ChatResponse chatResponse = chatModel.chat(aiMessage,userInputMessage);
		
//		BotAssistant botAssistant = AiServices.create(BotAssistant.class, chatModel);
//		BotAssistant botAssistant = AiServices.builder(BotAssistant.class)
//				                              .streamingChatModel(chatModel)
//				                              .chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(10))
//				                              .build();
		TokenStream chatResponse = botAssistant.chatWithBot(conversationId,input);
		return chatResponse;
//		return chatResponse.aiMessage().text();
	}
	
	public static StudyPlan prepareStudyPlanner(String topic) {
//		ChatModel chatModel = OpenAiChatModel.builder()
//                .apiKey(p.getApiKey())
//                .modelName(p.getModelName())
//                .temperature(p.getTemperature())
//                .build();	
		StudyPlanner studyPlanner = AiServices.create(StudyPlanner.class, chatModel);
		StudyPlan studyPlan = studyPlanner.getStudyPlan(topic);
		return studyPlan;
	}
}
