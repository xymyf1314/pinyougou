package entity;

import java.io.Serializable;

/**
 * @author Fan
 * @version 1.0
 * @date 2020/3/31 20:52
 */
public class Result implements Serializable {
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 返回信息
     */
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Result() {
    }
}
