package com.gxust.java.ai.langchain4j;

import com.gxust.java.ai.langchain4j.assistant.MemoryChatAssistant;
import com.gxust.java.ai.langchain4j.assistant.SeparateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PromptTest {

    @Autowired
    private SeparateChatAssistant separateChatAssistant;
    @Test
    public void testSystemMessage() {
        String answer = separateChatAssistant.chat(4,"今天多少号？");
        System.out.println(answer);
    }

    @Autowired
    private MemoryChatAssistant memoryChatAssistant;
    @Test
    public void testUserMessage(){
        String answer1 = memoryChatAssistant.chat("我是hansong");
        System.out.println(answer1);
        String answer2 = memoryChatAssistant.chat("你能推荐一些互联网的实习给我吗？");
        System.out.println(answer2);
    }

}
