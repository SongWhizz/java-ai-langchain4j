package com.gxust.java.ai.langchain4j;

import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LLMTest {

    @Test
    public void testGPTDemo(){
        // 初始化模型
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .apiKey("demo")
                .modelName("gpt-4o-mini")
                .build();

        String answer = model.chat("请问你是谁呀");
        System.out.println(answer);

    }


    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Test
    public void testSpringBoot(){
        String answer = openAiChatModel.chat("who am I?");
        System.out.println(answer);
    }

}
