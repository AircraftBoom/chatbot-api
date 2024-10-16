package study.kkk.chatbot.api.domain.ai.model.vo;


/**
 * ClassName: C
 * Description:
 *
 * @author pc
 * @version 1.0
 * @create 2024-10-16 14:59
 */
public class Choice{
    public int index;
    public Message message;
    public Object logprobs;
    public String finish_reason;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Object getLogprobs() {
        return logprobs;
    }

    public void setLogprobs(Object logprobs) {
        this.logprobs = logprobs;
    }

    public String getFinish_reason() {
        return finish_reason;
    }

    public void setFinish_reason(String finish_reason) {
        this.finish_reason = finish_reason;
    }
}