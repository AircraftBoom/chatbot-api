package study.kkk.chatbot.api.domain.zsxq.model.vo;

/**
 * ClassName: Talk
 * Description:
 *
 * @author pc
 * @version 1.0
 * @create 2024-10-15 19:02
 */
public class Talk {
    public Owner owner;
    public String text;
    public Article article;

    public Owner getOwner() {
        return owner;
    }

    public String getText() {
        return text;
    }

    public Article getArticle() {
        return article;
    }
}
