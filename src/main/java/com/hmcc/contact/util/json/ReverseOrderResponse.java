package com.hmcc.contact.util.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by lixiang on 2017/7/21.
 */
public class ReverseOrderResponse implements Serializable {

    @JsonProperty("origin_id")
    private String originId;

    @JsonProperty("order_id")
    private String orderId;

    @JsonProperty("reverse_order_id")
    private String reverseOrderId;

    @JsonProperty("reverse_trade_no")
    private String reverseTradeNo;

    @JsonProperty("code")
    private int code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("verify_code")
    private String verifyCode;

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getReverseOrderId() {
        return reverseOrderId;
    }

    public void setReverseOrderId(String reverseOrderId) {
        this.reverseOrderId = reverseOrderId;
    }

    public String getReverseTradeNo() {
        return reverseTradeNo;
    }

    public void setReverseTradeNo(String reverseTradeNo) {
        this.reverseTradeNo = reverseTradeNo;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }


}
