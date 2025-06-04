package com.gxust.java.ai.langchain4j;

import com.gxust.java.ai.langchain4j.bean.ChatMessages;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@SpringBootTest
public class MongoCrudTest {
    @Autowired
    private MongoTemplate mongoTemplate;


/*    @Test
    public void testInsert() {

        mongoTemplate.insert(new ChatMessages(1L, " 聊天记录"));
    }*/

    @Test
    public void testInsert2() {
        ChatMessages chatMessages = new ChatMessages();
        chatMessages.setContent("聊天记录列表");
        mongoTemplate.insert(chatMessages);
    }


    @Test
    public void testFindById(){
        ChatMessages chatMessages = mongoTemplate.findById("683fbca4d75b4e2488fb0830", ChatMessages.class);
        System.out.println(chatMessages);
    }

    @Test
    public void testUpdate(){
        Criteria criteria = Criteria.where("_id").is("683fbca4d75b4e2488fb0830");
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content", "新的聊天记录列表");

        mongoTemplate.upsert(query, update, ChatMessages.class);
    }

    @Test
    public void testUpdate2(){
        Criteria criteria = Criteria.where("_id").is("100");
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content", "100的聊天记录列表");

        // 修改或新增
        mongoTemplate.upsert(query, update, ChatMessages.class);
    }



    @Test
    public void testDelete(){
        Criteria criteria = Criteria.where("_id").is("100");
        Query query = new Query(criteria);
        mongoTemplate.remove(query, ChatMessages.class);
    }


}
