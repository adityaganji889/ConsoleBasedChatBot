# 🤖 Console Based AI ChatBot

A Java-based AI-powered console chatbot built using LangChain4j and OpenAI. This project demonstrates AI conversations, streaming responses, conversation memory, custom tools, and AI-powered study planning.

## ✨ Features

- AI-powered conversations using OpenAI.
- Streaming responses token by token.
- Conversation memory using MessageWindowChatMemory.
- AI-generated personalized study plans.
- Structured AI responses using Java DTOs.
- Custom tool integration:
  - CalculatorTool
  - DateAndTimeTool
  - FileWriteTool
- Interactive console-based interface.

## 🛠️ Tech Stack

- Java
- LangChain4j
- OpenAI
- Maven
- SLF4J

## 🚀 Features in Detail

### 1. AI Chatbot

Interact with an AI assistant through the console using natural language.

### 2. AI Study Planner

Enter a topic to generate a personalized study plan containing:
- Study plan title
- Total number of days
- Recommended study hours per day
- Daily learning topics
- Detailed learning content
- Practice questions

### 3. Conversation Memory

Uses LangChain4j's MessageWindowChatMemory to maintain recent conversation context.

```java
.chatMemoryProvider(memoryId ->
    MessageWindowChatMemory.withMaxMessages(10)
)
```

### 4. Streaming Responses

Uses OpenAiStreamingChatModel to display responses progressively.

```java
tokenStream
    .onPartialResponse(token -> System.out.print(token))
    .onCompleteResponse(response -> System.out.println())
    .start();
```

### 5. Custom Tools Integration

- CalculatorTool: Performs mathematical calculations.
- DateAndTimeTool: Provides date and time-related functionality.
- FileWriteTool: Provides file-writing functionality.

## 📂 Project Structure

```text
ConsoleBasedChatBot/
├── langchain4jchat/
│   ├── src/main/java/com/chatbot/langchain4jchat/
│   │   ├── App.java
│   │   ├── config/
│   │   │   └── LoadProperties.java
│   │   ├── service/
│   │   │   ├── ChatHelper.java
│   │   │   ├── BotAssistant.java
│   │   │   └── StudyPlanner.java
│   │   ├── dto/
│   │   │   ├── StudyPlan.java
│   │   │   └── DayPlan.java
│   │   └── tools/
│   │       ├── CalculatorTool.java
│   │       ├── DateAndTimeTool.java
│   │       └── FileWriteTool.java
│   └── pom.xml
└── README.md
```

## ⚙️ Prerequisites

- Java Development Kit (JDK-17/17+ (bare minimum))
- Maven
- OpenAI API key
- Internet connectivity

## 🔧 Configuration

1. Obtain an API key from [OpenAI Platform](https://platform.openai.com/api-keys).
2. Configure your API key, model name, and temperature using the configuration expected by LoadProperties.java.
3. Never commit your API key or other secrets to GitHub.

## ▶️ How to Run

### Step 1: Clone the repository

```bash
git clone https://github.com/adityaganji889/ConsoleBasedChatBot.git
```

### Step 2: Navigate to the project directory

```bash
cd ConsoleBasedChatBot/langchain4jchat
```

### Step 3: Configure your OpenAI API credentials

Set up the configuration expected by LoadProperties.java.

### Step 4: Build the project

```bash
mvn clean install
```

### Step 5: Run the application

```bash
mvn exec:java -Dexec.mainClass="com.chatbot.langchain4jchat.App"
```

Alternatively, run App.java directly from your IDE.

## 💡 Learning Objectives

- Integrating OpenAI models with Java applications.
- Using LangChain4j for AI application development.
- Implementing streaming AI responses.
- Managing conversational context and memory.
- Creating AI services using AiServices.
- Generating structured responses using Java DTOs.
- Integrating custom tools with AI assistants.
- Building interactive console-based applications.

