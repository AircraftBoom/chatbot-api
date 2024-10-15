package study.kkk.chatbot.api.domain.zsxq.model.vo;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author 小傅哥，微信：fustack
 * @description
 * @github https://github.com/fuzhengwei
 * @copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class Topics {

    public String topic_id;
    public Group group;
    public String type;
    public Talk talk;
    public int likes_count;
    public int rewards_count;
    public int comments_count;
    public int reading_count;
    public int readers_count;
    public boolean digested;
    public boolean sticky;
    public Date create_time;
    public UserSpecific user_specific;
    public String title;
    public ArrayList<ShowComment> show_comments;


    public String getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Talk getTalk() {
        return talk;
    }

    public void setTalk(Talk talk) {
        this.talk = talk;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public int getRewards_count() {
        return rewards_count;
    }

    public void setRewards_count(int rewards_count) {
        this.rewards_count = rewards_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getReading_count() {
        return reading_count;
    }

    public void setReading_count(int reading_count) {
        this.reading_count = reading_count;
    }

    public int getReaders_count() {
        return readers_count;
    }

    public void setReaders_count(int readers_count) {
        this.readers_count = readers_count;
    }

    public boolean isDigested() {
        return digested;
    }

    public void setDigested(boolean digested) {
        this.digested = digested;
    }

    public boolean isSticky() {
        return sticky;
    }

    public void setSticky(boolean sticky) {
        this.sticky = sticky;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<ShowComment> getShow_comments() {
        return show_comments;
    }

    public void setShow_comments(ArrayList<ShowComment> show_comments) {
        this.show_comments = show_comments;
    }

    public void setUser_specific(study.kkk.chatbot.api.domain.zsxq.model.vo.UserSpecific user_specific){
        this.user_specific = user_specific;
    }
    public study.kkk.chatbot.api.domain.zsxq.model.vo.UserSpecific getUser_specific(){
        return this.user_specific;
    }

}
