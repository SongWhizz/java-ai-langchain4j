package com.gxust.java.ai.langchain4j;

import com.gxust.java.ai.langchain4j.assistant.Assistant;
import com.gxust.java.ai.langchain4j.assistant.MemoryChatAssistant;
import com.gxust.java.ai.langchain4j.assistant.SeparateChatAssistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class ChatMemoryTest {

    @Autowired
    private Assistant assistant;
    @Test
    public void testChatMemory() {
        String answer1 = assistant.chat("我是chs");
        System.out.println(answer1);
        String answer2 = assistant.chat("我是谁");
        System.out.println(answer2);
    }


    @Autowired
    private QwenChatModel qwenChatModel;
    @Test
    public void testChatMemory2() {
        //第一轮对话
        UserMessage userMessage1 = UserMessage.userMessage("我是嵩");
        ChatResponse chatResponse1 = qwenChatModel.chat(userMessage1);
        AiMessage aiMessage1 = chatResponse1.aiMessage();

        //输出大语言模型的回复
        System.out.println(aiMessage1.text());

        //第二轮对话
        UserMessage userMessage2 = UserMessage.userMessage("你知道我是谁吗");
        ChatResponse chatResponse2 = qwenChatModel.chat(Arrays.asList(userMessage1,
                aiMessage1, userMessage2));
        AiMessage aiMessage2 = chatResponse2.aiMessage();

        //输出大语言模型的回复
        System.out.println(aiMessage2.text());
    }


    @Test
    public void testChatMemory3(){
        // 创建chatMemory
        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);

        // 创建AiService
        Assistant assitant = AiServices
                .builder(Assistant.class)
                .chatLanguageModel(qwenChatModel)
                .chatMemory(chatMemory)
                .build();

        // 调用service的接口
        String answer1 = assitant.chat("我是嵩");
        System.out.println(answer1);
        String answer2 = assitant.chat("我是谁？");
        System.out.println(answer2);
    }


    @Autowired
    private MemoryChatAssistant memoryChatAssistant;
    @Test
    public void testChatMemory4(){

        // 调用memoryChatAssistant的接口
        String answer1 = memoryChatAssistant.chat("我是嵩");
        System.out.println(answer1);
        String answer2 = memoryChatAssistant.chat("我是谁？");
        System.out.println(answer2);
    }


    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void testChatMemory5(){

        // 调用memoryChatAssistant的接口
        String answer1 = separateChatAssistant.chat(1, "我是hansong");
        System.out.println(answer1);

        String answer2 = separateChatAssistant.chat(1, "我是谁？");
        System.out.println(answer2);

        String answer3 = separateChatAssistant.chat(2, "我是谁？");
        System.out.println(answer3);
    }





}
