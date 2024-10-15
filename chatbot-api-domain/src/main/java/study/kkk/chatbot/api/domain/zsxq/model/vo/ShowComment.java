package study.kkk.chatbot.api.domain.zsxq.model.vo;

import java.util.Date;

/**
 * ClassName: ShowComment
 * Description:
 *
 * @author pc
 * @version 1.0
 * @create 2024-10-15 19:03
 */
public class ShowComment {
    public Object comment_id;
    public Date create_time;
    public Owner owner;
    public String text;
    public int likes_count;
    public int rewards_count;
    public boolean sticky;
}
