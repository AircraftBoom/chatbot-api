package study.kkk.chatbot.api.domain.ai.model.aggregates;

import study.kkk.chatbot.api.domain.ai.model.vo.Choice;
import study.kkk.chatbot.api.domain.ai.model.vo.Usage;

import java.util.ArrayList;

/**
 * ClassName: AiAnswer
 * Description:
 *
 * @author pc
 * @version 1.0
 * @create 2024-10-16 15:39
 */
public class AiAnswer {
    public String id;
    public String object;
    public int created;
    public String model;
    public ArrayList<Choice> choices;
    public Usage usage;
    public String system_fingerprint;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ArrayList<Choice> getChoices() {
        return choices;
    }

    public void setChoices(ArrayList<Choice> choices) {
        this.choices = choices;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    public String getSystem_fingerprint() {
        return system_fingerprint;
    }

    public void setSystem_fingerprint(String system_fingerprint) {
        this.system_fingerprint = system_fingerprint;
    }
}
