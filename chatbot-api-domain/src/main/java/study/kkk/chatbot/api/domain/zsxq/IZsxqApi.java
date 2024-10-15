package study.kkk.chatbot.api.domain.zsxq;

import study.kkk.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;

import java.io.IOException;

/**
 * ClassName: ZsxqApi
 * Description:
 *
 * @author pc
 * @version 1.0
 * @create 2024-10-15 15:39
 */
public interface IZsxqApi {
    UnAnsweredQuestionsAggregates topicIdOfTheUnansweredQuestion(String groupId, String cookie) throws IOException;

    boolean answer(String groupId, String cookie, String topicId, String text) throws IOException;
}
