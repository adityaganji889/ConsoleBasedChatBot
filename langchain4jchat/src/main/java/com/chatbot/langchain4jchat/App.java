package com.chatbot.langchain4jchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.chatbot.langchain4jchat.service.ChatHelper;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        
    	System.out.println("-------Welcome to ChatBot-------");
    	BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    	System.out.println("Start Conversation with ChatBot....");
    	System.out.println("Press anytime quit to exit");
    	System.out.println("");
        while(true) {
        	 System.out.print("You: ");
        	 String inputValue = bfr.readLine().trim();
        	 if(inputValue.equalsIgnoreCase("quit")) {
        		 System.out.println("Exiting ChatBot...");
        		 System.out.println("Thank you for using ChatBot!");
        		 break;
        	 }
        	 String response = ChatHelper.getResponse(inputValue);
        	//llm call
             System.out.println("ChatBot: "+response);
        }
    }
}
