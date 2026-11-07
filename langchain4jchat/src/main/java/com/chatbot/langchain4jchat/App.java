package com.chatbot.langchain4jchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.chatbot.langchain4jchat.dto.DayPlan;
import com.chatbot.langchain4jchat.dto.StudyPlan;
import com.chatbot.langchain4jchat.service.ChatHelper;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        
    	System.out.println("-------Welcome to ChatBot-------");
    	BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    	System.out.println("Start Conversation with ChatBot....");
    	System.out.println("- Press 1 to create study plan.");
    	System.out.println("- Press anytime quit to exit.");
    	System.out.println("");
        while(true) {
        	 System.out.print("You: ");
        	 String inputValue = bfr.readLine().trim();
        	 if(inputValue.equalsIgnoreCase("quit")) {
        		 System.out.println("Exiting ChatBot...");
        		 System.out.println("Thank you for using ChatBot!");
        		 break;
        	 }
        	 try {
        		 int val = (int)Integer.parseInt(inputValue);
        		 if(val == 1) {
        			System.out.println("Enter the topic:");
        			String topic = bfr.readLine().trim();
        			StudyPlan studyPlan = ChatHelper.prepareStudyPlanner(topic);
        			System.out.println("-------Study Plan for topic: "+studyPlan.planTitle());
        			System.out.println("Number of days to follow:"+studyPlan.numberOfDays());
        			System.out.println("Hours per day:"+studyPlan.hoursPerDay());
        			System.out.println("Day Plans:");
        			for(DayPlan dayPlan : studyPlan.dayPlans()) {
        				System.out.println("Day:"+dayPlan.dayNumber()+": "+dayPlan.title());
        				System.out.println(dayPlan.content());
        				System.out.println("Practice Questions:"+dayPlan.practiceQuestions());
        			    System.out.println("++");
        			}
        			continue;
        		 }
        	 }
        	 catch(NumberFormatException e) {
        		 
        	 }
        	 String response = ChatHelper.getResponse(inputValue);
        	//llm call
             System.out.println("ChatBot: "+response);
        }
    }
}
