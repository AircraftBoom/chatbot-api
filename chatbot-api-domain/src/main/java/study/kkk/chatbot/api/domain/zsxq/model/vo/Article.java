package study.kkk.chatbot.api.domain.zsxq.model.vo;

/**
 * ClassName: Article
 * Description:
 *
 * @author pc
 * @version 1.0
 * @create 2024-10-15 19:04
 */
public class Article {
    private String title;
    private String article_id;
    private String article_url;
    private String inline_article_url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public String getArticle_url() {
        return article_url;
    }

    public void setArticle_url(String article_url) {
        this.article_url = article_url;
    }

    public String getInline_article_url() {
        return inline_article_url;
    }

    public void setInline_article_url(String inline_article_url) {
        this.inline_article_url = inline_article_url;
    }
}
