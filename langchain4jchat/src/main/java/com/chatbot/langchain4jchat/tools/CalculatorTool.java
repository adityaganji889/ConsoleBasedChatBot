package com.chatbot.langchain4jchat.tools;

import dev.langchain4j.agent.tool.Tool;

public class CalculatorTool {

	@Tool
	public int add(int a, int b) {
		System.out.println("Adding provided 2 nos.:"+a+","+b);
		return a+b;
	}
	
	@Tool
	public int multiply(int a, int b) {
		System.out.println("Multiplying provided 2 nos.:"+a+","+b);
		return a*b;
	}
	
	@Tool
	public int subtract(int a, int b) {
		System.out.println("Subtracting provided 2 nos.:"+a+","+b);
		return a-b;
	}
	
	@Tool
	public int divide(int a, int b) {
		System.out.println("Dividing provided 2 nos.:"+a+","+b);
		return a/b;
	}
}
