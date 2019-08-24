package entity;

/**
 * @description:
 * @author: zheng-fx
 * @time: 2019/8/23 0023 07:30
 */
public class Result {
    private boolean success;
    private String message;
    

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

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
}
