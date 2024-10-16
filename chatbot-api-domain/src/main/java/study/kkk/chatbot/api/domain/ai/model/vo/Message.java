package study.kkk.chatbot.api.domain.ai.model.vo;

/**
 * ClassName: w
 * Description:
 *
 * @author pc
 * @version 1.0
 * @create 2024-10-16 14:59
 */
public class Message{
    public String role;
    public String content;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}