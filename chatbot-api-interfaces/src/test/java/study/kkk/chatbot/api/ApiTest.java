package study.kkk.chatbot.api;

import com.alibaba.fastjson.JSON;
import io.github.bonigarcia.wdm.online.HttpClient;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import study.kkk.chatbot.api.domain.ai.model.aggregates.AiAnswer;
import study.kkk.chatbot.api.domain.ai.model.vo.Choice;

import java.beans.Transient;
import java.io.IOException;

/**
 * ClassName: ApiTest
 * Description:
 *
 * @author pc
 * @version 1.0
 * @create 2024-10-14 21:00
 */
public class ApiTest {
    @Test
    public void queryNotAnsweredQuestions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/88888155485212/topics?scope=all&count=20");

        get.addHeader("cookie", "zsxq_access_token=B0763ABD-AAD0-B111-A06B-A96775DF8AEF_0CE716C712480126; zsxqsessionid=4d53cf877fbde1b37bee79d4e6729776; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22184418282528442%22%2C%22first_id%22%3A%221928a3cc91ca9b-0a0a1d139855f7-26001051-2073600-1928a3cc91df4%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTkyOGEzY2M5MWNhOWItMGEwYTFkMTM5ODU1ZjctMjYwMDEwNTEtMjA3MzYwMC0xOTI4YTNjYzkxZGY0IiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiMTg0NDE4MjgyNTI4NDQyIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22184418282528442%22%7D%2C%22%24device_id%22%3A%221928a3cc91ca9b-0a0a1d139855f7-26001051-2073600-1928a3cc91df4%22%7D");
        get.addHeader("Content-Type", "application/json, text/plain, */*");

        CloseableHttpResponse response = httpClient.execute(get);

        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/1525458888528412/comments");

        post.addHeader("cookie", "zsxq_access_token=B0763ABD-AAD0-B111-A06B-A96775DF8AEF_0CE716C712480126; zsxqsessionid=4d53cf877fbde1b37bee79d4e6729776; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22184418282528442%22%2C%22first_id%22%3A%221928a3cc91ca9b-0a0a1d139855f7-26001051-2073600-1928a3cc91df4%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTkyOGEzY2M5MWNhOWItMGEwYTFkMTM5ODU1ZjctMjYwMDEwNTEtMjA3MzYwMC0xOTI4YTNjYzkxZGY0IiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiMTg0NDE4MjgyNTI4NDQyIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22184418282528442%22%7D%2C%22%24device_id%22%3A%221928a3cc91ca9b-0a0a1d139855f7-26001051-2073600-1928a3cc91df4%22%7D");
        post.addHeader("Content-Type", "application/json, text/plain, */*");

        String paramJSON = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"我也不知道\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJSON, ContentType.create("text/json", "utf-8"));

        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);

        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void testDeepSeek() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost("https://api.deepseek.com/chat/completions");
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("Authorization", "Bearer sk-97dd0c4a729e4b169653bdb14a9d8f74");

        String paramJson = "{\n" +
                "        \"model\": \"deepseek-chat\",\n" +
                "        \"messages\": [\n" +
                "          {\"role\": \"system\", \"content\": \"You are a helpful assistant.\"},\n" +
                "          {\"role\": \"user\", \"content\": \"我该如何找到工作？\"}\n" +
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

            System.out.println(answerStr);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
