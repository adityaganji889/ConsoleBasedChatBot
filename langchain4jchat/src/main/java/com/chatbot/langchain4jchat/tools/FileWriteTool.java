package com.chatbot.langchain4jchat.tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;

public class FileWriteTool {

	@Tool
	public void writeFile(@P("name of the file to write to with extension")String fileName,@P("content to write to the file")String content) {
		System.out.println("Writing file");
		System.out.println("Writing file name:"+fileName);
		System.out.println("Writing file content:"+content);
		String filePath = System.getProperty("user.dir") + File.separator + "files" + File.separator + fileName;
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
			try {
				bw.write(content);
				bw.close();
			}
			catch(Exception e) {
				System.out.println("Error while writing to file:"+e.getMessage());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in file writing tool:"+e.getMessage());
		}
	}
	
}
