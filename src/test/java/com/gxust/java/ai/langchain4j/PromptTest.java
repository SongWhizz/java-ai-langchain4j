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

    @Test
    public void testV() {
        String answer1 = separateChatAssistant.chat2(10, "我是hansong");
        System.out.println(answer1);
        String answer2 = separateChatAssistant.chat2(10, "我是谁");
        System.out.println(answer2);
    }

    @Test
    public void testUserInfo() {
        // 从数据库中获取
        String usrename = "张三";
        int age = 18;
        String answer = separateChatAssistant.chat3(11, "我是谁，我多大了", usrename, age);
        System.out.println(answer);
    }

}
