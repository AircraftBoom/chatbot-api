package study.kkk.chatbot.api;

import com.alibaba.fastjson.JSON;
import com.google.common.base.CharMatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import study.kkk.chatbot.api.domain.zsxq.IZsxqApi;
import study.kkk.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import study.kkk.chatbot.api.domain.zsxq.model.vo.Topics;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Timer;

/**
 * ClassName: SpringBootRunTest
 * Description:
 *
 * @author pc
 * @version 1.0
 * @create 2024-10-15 16:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRunTest {
    private Logger logger = LoggerFactory.getLogger(SpringBootRunTest.class);

    @Value("${chatbot-api.groupId}")
    private String groupId;

    @Value("${chatbot-api.cookie}")
    private String cookie;

    @Resource
    private IZsxqApi zsxqApi;

    @Test
    public void testZsxqApi() throws IOException, InterruptedException {
        UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi.topicIdOfTheUnansweredQuestion(groupId, cookie);
        logger.info("测试结果{}", JSON.toJSONString(unAnsweredQuestionsAggregates));

        List<Topics> topics = unAnsweredQuestionsAggregates.getResp_data().getTopics();
        for(Topics topic : topics){
            String topicId = topic.getTopic_id();
            String text = topic.getTalk().getText();
            //CharMatcher.breakingWhitespace().removeFrom(text);
            String[] split = text.split("\\n\\n");
            text = split[split.length - 1];
            text = text.substring(0, text.length() -3);
            logger.info("获取到的问题：groupId:{}, text:{}", topicId, text);

            boolean answered = zsxqApi.answer(groupId, cookie, topicId, "测试3");

            logger.info("回答{}结果成功：{}", text, answered);

            Thread.sleep(3000);
        }
    }
}
