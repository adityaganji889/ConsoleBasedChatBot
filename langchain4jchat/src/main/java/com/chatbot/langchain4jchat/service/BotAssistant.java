package com.chatbot.langchain4jchat.service;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.TokenStream;
import dev.langchain4j.service.UserMessage;

public interface BotAssistant {

	@SystemMessage(fromResource = "ai-system-prompt.txt")
	public TokenStream chatWithBot(@MemoryId int memoryId,@UserMessage String input);
	
}
