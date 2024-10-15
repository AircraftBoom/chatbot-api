package study.kkk.chatbot.api.domain.zsxq.model.vo;

import java.util.ArrayList;

/**
 * @author 小傅哥，微信：fustack
 * @description
 * @github https://github.com/fuzhengwei
 * @copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class UserSpecific {

    public boolean liked;
    public ArrayList<Object> liked_emojis;
    public boolean subscribed;

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public ArrayList<Object> getLiked_emojis() {
        return liked_emojis;
    }

    public void setLiked_emojis(ArrayList<Object> liked_emojis) {
        this.liked_emojis = liked_emojis;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }
}
