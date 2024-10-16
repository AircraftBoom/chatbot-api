package study.kkk.chatbot.api.application.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import study.kkk.chatbot.api.domain.ai.IDeepSeekApi;
import study.kkk.chatbot.api.domain.zsxq.IZsxqApi;
import study.kkk.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import study.kkk.chatbot.api.domain.zsxq.model.res.RespData;
import study.kkk.chatbot.api.domain.zsxq.model.vo.Topics;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

/**
 * ClassName: ChatbotSchedule
 * Description:
 *
 * @author pc
 * @version 1.0
 * @create 2024-10-16 18:52
 */
@EnableScheduling
@Configuration
public class ChatbotSchedule {

    private Logger logger = LoggerFactory.getLogger(ChatbotSchedule.class);

    @Value("${chatbot-api.groupId}")
    private String groupId;

    @Value("${chatbot-api.cookie}")
    private String cookie;

    @Resource
    private IZsxqApi zsxqApi;

    @Resource
    private IDeepSeekApi deepSeekApi;

    @Scheduled(cron = "0/5 * * * * ?")
    public void run(){
        try {
            if(new Random().nextBoolean()){
                logger.info("随机打烊中...");
                return;
            }

            GregorianCalendar calendar = new GregorianCalendar();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);

            if(hour > 23 || hour < 5){
                logger.info("时间太晚，打烊中...");
                return;
            }

            UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi.topicIdOfTheUnansweredQuestion(groupId, cookie);
            RespData respData = unAnsweredQuestionsAggregates.getResp_data();
            List<Topics> topics = respData.getTopics();
            if(topics == null || topics.isEmpty()){
                logger.info("本次查询没有问题");
                return;
            }

            Topics topic1 = topics.get(topics.size() - 1);
            String originalText = topic1.getTalk().getText();
            String[] splitedText = originalText.split("\n\n");
            String s = splitedText[splitedText.length - 1];
            s.substring(0, s.length()-3);
            String answer = deepSeekApi.doDeepSeek(s);
            boolean answered = zsxqApi.answer(groupId, cookie, topic1.getTopic_id(), answer);
            if(answered){
                logger.info("完成回答，编号：{}， 问题：{}， 答案：{}", groupId, s, answer);
            }else {
                logger.info("回答失败，编号：{}， 问题：{}", groupId, s);
            }

        }catch (Exception e){
            logger.error("回答异常，{}", e);
        }
    }
}
