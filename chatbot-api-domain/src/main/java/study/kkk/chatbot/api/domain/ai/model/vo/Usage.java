package study.kkk.chatbot.api.domain.ai.model.vo;

/**
 * ClassName: Usage
 * Description:
 *
 * @author pc
 * @version 1.0
 * @create 2024-10-16 15:01
 */
public class Usage{
    public int prompt_tokens;
    public int completion_tokens;
    public int total_tokens;
    public int prompt_cache_hit_tokens;
    public int prompt_cache_miss_tokens;

    public int getPrompt_tokens() {
        return prompt_tokens;
    }

    public void setPrompt_tokens(int prompt_tokens) {
        this.prompt_tokens = prompt_tokens;
    }

    public int getCompletion_tokens() {
        return completion_tokens;
    }

    public void setCompletion_tokens(int completion_tokens) {
        this.completion_tokens = completion_tokens;
    }

    public int getTotal_tokens() {
        return total_tokens;
    }

    public void setTotal_tokens(int total_tokens) {
        this.total_tokens = total_tokens;
    }

    public int getPrompt_cache_hit_tokens() {
        return prompt_cache_hit_tokens;
    }

    public void setPrompt_cache_hit_tokens(int prompt_cache_hit_tokens) {
        this.prompt_cache_hit_tokens = prompt_cache_hit_tokens;
    }

    public int getPrompt_cache_miss_tokens() {
        return prompt_cache_miss_tokens;
    }

    public void setPrompt_cache_miss_tokens(int prompt_cache_miss_tokens) {
        this.prompt_cache_miss_tokens = prompt_cache_miss_tokens;
    }
}
