package com.chatbot.langchain4jchat.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

	private String apiKey;
	private String modelName;
	private Double temperature;
	
	public LoadProperties() {
		
		
		String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "langchain4jchat.properties";
		
		Properties p = new Properties();
		try {
			File file = new File(filePath);
			FileReader fis = new FileReader(file);
			p.load(new BufferedReader(fis));	
		}
		catch(IOException e) {
		    System.out.println("Exception occurred while loading properties:"+e.getMessage());
		}
		this.apiKey = p.getProperty("OPENAI_API_KEY");
		this.modelName = p.getProperty("AI_MODEL");
		this.temperature = Double.parseDouble(p.getProperty("TEMPERATURE"));
	}
	
	public String getApiKey() {
		return apiKey;
	}
	
	public String getModelName() {
		return modelName;
	}
	
	public Double getTemperature() {
		return temperature;
	}
	
}
