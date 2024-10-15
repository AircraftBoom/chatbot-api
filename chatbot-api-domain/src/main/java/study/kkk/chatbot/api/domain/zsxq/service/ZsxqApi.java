package study.kkk.chatbot.api.domain.zsxq.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import study.kkk.chatbot.api.domain.zsxq.IZsxqApi;
import study.kkk.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import study.kkk.chatbot.api.domain.zsxq.model.req.AnswerReq;
import study.kkk.chatbot.api.domain.zsxq.model.req.ReqData;
import study.kkk.chatbot.api.domain.zsxq.model.res.AnswerRes;

import java.io.IOException;
import java.util.Arrays;

/**
 * ClassName: ZsxqApi
 * Description:
 *
 * @author pc
 * @version 1.0
 * @create 2024-10-15 15:58
 */
@Service
public class ZsxqApi implements IZsxqApi {

    private Logger logger = LoggerFactory.getLogger(ZsxqApi.class);
    @Override
    public UnAnsweredQuestionsAggregates topicIdOfTheUnansweredQuestion(String groupId, String cookie) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/" + groupId + "/topics?scope=all&count=20");

        get.addHeader("cookie", cookie);
        get.addHeader("Content-Type", "application/json, text/plain, */*");

        CloseableHttpResponse response = httpClient.execute(get);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String jsonStr = EntityUtils.toString(response.getEntity());
            logger.info("拉取问题的结果：groupId:{}, jsonStr{}", groupId, jsonStr);
            //logger.info("content-type:{}", Arrays.toString(response.getHeaders("content-type")));
            return JSON.parseObject(jsonStr, UnAnsweredQuestionsAggregates.class);
        } else {
            throw new RuntimeException("topicIdOfTheUnansweredQuestion Err coid is" + response.getStatusLine().getStatusCode());
        }
    }


    @Override
    public boolean answer(String groupId, String cookie, String topicId, String text) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/"+ topicId+ "/comments");

        post.addHeader("cookie", cookie);
        post.addHeader("Content-Type", "application/json, text/plain, */*");
        post.addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/129.0.0.0 Safari/537.36");


        AnswerReq answerReq = new AnswerReq(new ReqData(text));
        String paramJSON = JSONObject.toJSON(answerReq).toString();
        StringEntity stringEntity = new StringEntity(paramJSON, ContentType.create("text/json", "utf-8"));

        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);

        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String jsonStr = EntityUtils.toString(response.getEntity());
            logger.info("回答的结果：groupId:{}, topicId:{}, jsonStr{}", groupId, topicId, jsonStr);
            AnswerRes answerRes = JSON.parseObject(jsonStr, AnswerRes.class);

            return answerRes.isSucceeded();
        }else{
            return false;
        }
    }
}
