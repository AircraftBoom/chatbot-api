package study.kkk.chatbot.api.domain.zsxq.model.vo;

import study.kkk.chatbot.api.domain.zsxq.model.res.RespData;

/**
 * ClassName: Root
 * Description:
 *
 * @author pc
 * @version 1.0
 * @create 2024-10-15 19:05
 */
public class Root {
    public boolean succeeded;
    public RespData resp_data;

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }

    public RespData getResp_data() {
        return resp_data;
    }

    public void setResp_data(RespData resp_data) {
        this.resp_data = resp_data;
    }
}
