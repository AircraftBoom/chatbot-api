package study.kkk.chatbot.api.domain.ai.service;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import study.kkk.chatbot.api.domain.ai.IDeepSeekApi;
import study.kkk.chatbot.api.domain.ai.model.aggregates.AiAnswer;
import study.kkk.chatbot.api.domain.ai.model.vo.Choice;

import java.io.IOException;

/**
 * ClassName: DeepSeek
 * Description:
 *
 * @author pc
 * @version 1.0
 * @create 2024-10-16 14:57
 */
@Service
public class DeepSeekApi implements IDeepSeekApi {
    private Logger logger = LoggerFactory.getLogger(DeepSeekApi.class);

    @Value("${chatbot-api.deepSeekApiKey}")
    private String deepSeekApiKey;

    @Override
    public String doDeepSeek(String question) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost("https://api.deepseek.com/chat/completions");
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("Authorization", "Bearer " + deepSeekApiKey);

        String paramJson = "{\n" +
                "        \"model\": \"deepseek-chat\",\n" +
                "        \"messages\": [\n" +
                "          {\"role\": \"system\", \"content\": \"You are a helpful assistant.\"},\n" +
                "          {\"role\": \"user\", \"content\": \"" + question +
                "            \"}\n" +
                "        ],\n" +
                "        \"stream\": false\n" +
                "      }";
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "utf-8"));
        httpPost.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(httpPost);

        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            AiAnswer answer = JSON.parseObject(res, AiAnswer.class);
            StringBuilder answerStr = new StringBuilder();
            for(Choice choice : answer.getChoices()){
                answerStr.append(choice.getMessage().getContent());
            }
            logger.info("{}\n{}", question, answerStr);

            return answerStr.toString();
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
            return "failed";
        }
    }
}
