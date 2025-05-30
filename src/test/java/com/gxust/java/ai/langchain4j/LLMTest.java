package com.gxust.java.ai.langchain4j;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
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
    // LangChain4j支持接入的大模型：https://docs.langchain4j.dev/integrations/language-models/

    @Test
    public void testSpringBoot(){
        String answer = openAiChatModel.chat("你是谁?");
        System.out.println(answer);
    }

    @Autowired
    private OllamaChatModel ollamaChatModel;

    @Test
    public void testOllama(){
        String answer = ollamaChatModel.chat("你是何物？");
        System.out.println(answer);
    }

    @Autowired
    private QwenChatModel qwenChatModel;

    @Test
    public void testDashScopeQwen(){
        String answer = qwenChatModel.chat("你好，你是谁？");
        System.out.println(answer);
    }

}
