package study.kkk.chatbot.api.domain.ai;

import java.io.IOException;

/**
 * ClassName: IDeepSeek
 * Description:
 *
 * @author pc
 * @version 1.0
 * @create 2024-10-16 14:57
 */
public interface IDeepSeekApi {
    String doDeepSeek(String question) throws IOException;
}
