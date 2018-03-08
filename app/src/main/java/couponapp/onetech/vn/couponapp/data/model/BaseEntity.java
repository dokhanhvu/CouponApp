package couponapp.onetech.vn.couponapp.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BaseEntity<T> implements Serializable {

    @SerializedName("err_code")
    private String errorCode;

    @SerializedName("err_msg")
    private String errorMsg;

    @SerializedName("data")
    private T data;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
