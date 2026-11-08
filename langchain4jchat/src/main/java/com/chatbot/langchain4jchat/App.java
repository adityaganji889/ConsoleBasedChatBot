package com.chatbot.langchain4jchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.CompletableFuture;

import com.chatbot.langchain4jchat.dto.DayPlan;
import com.chatbot.langchain4jchat.dto.StudyPlan;
import com.chatbot.langchain4jchat.service.ChatHelper;

import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.service.TokenStream;

public class App {
	public static void main(String[] args) throws IOException {

		System.out.println("-------Welcome to ChatBot-------");
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Start Conversation with ChatBot....");
		System.out.println("- Press 1 to create study plan.");
		System.out.println("- Press anytime quit to exit.");
		System.out.println("");
		int conversationId = 0;
		while (true) {
			System.out.print("You: ");
			String inputValue = bfr.readLine().trim();
			conversationId++;
			if (inputValue.equalsIgnoreCase("quit")) {
				System.out.println("Exiting ChatBot...");
				System.out.println("Thank you for using ChatBot!");
				break;
			}
			try {
				int val = (int) Integer.parseInt(inputValue);
				if (val == 1) {
					System.out.print("Enter the topic:");
					String topic = bfr.readLine().trim();
					StudyPlan studyPlan = ChatHelper.prepareStudyPlanner(topic);
					System.out.println("-------Study Plan for topic: " + studyPlan.planTitle());
					System.out.println("Number of days to follow:" + studyPlan.numberOfDays());
					System.out.println("Hours per day:" + studyPlan.hoursPerDay());
					System.out.println("Day Plans:");
					for (DayPlan dayPlan : studyPlan.dayPlans()) {
						System.out.println("Day:" + dayPlan.dayNumber() + ": " + dayPlan.title());
						System.out.println(dayPlan.content());
						System.out.println("Practice Questions:" + dayPlan.practiceQuestions());
						System.out.println("++");
					}
					continue;
				}
			} catch (NumberFormatException e) {

			}
			TokenStream tokenStream = ChatHelper.chatWithBot(conversationId,inputValue);
			CompletableFuture<ChatResponse> futureResponse = new CompletableFuture<>();
			// llm call
//             System.out.println("ChatBot: "+response);
			System.out.print("ChatBot: ");
			tokenStream.onCompleteResponse(chatResponse -> {
				System.out.println();
				futureResponse.complete(chatResponse);
			}).onPartialResponse(token -> {
				System.out.print(token);
			}).onError(error -> {
				System.out.println("Error:"+error.getMessage());
			}).start();
			
			futureResponse.join();
		}
	}
}
