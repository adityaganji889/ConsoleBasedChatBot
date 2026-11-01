package com.chatbot.langchain4jchat.service;

import dev.langchain4j.service.SystemMessage;

public interface BotAssistant {

	@SystemMessage(fromResource = "ai-system-prompt.txt")
	public String getResponse(String input);
	
}
