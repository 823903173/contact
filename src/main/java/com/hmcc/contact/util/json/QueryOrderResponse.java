package com.hmcc.contact.util.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by lixiang on 2017/7/21.
 */
public class QueryOrderResponse implements Serializable {

    @JsonProperty("origin_id")
    private String originId;

    @JsonProperty("order_id")
    private String orderId;

    @JsonProperty("pay_order_id")
    private String payOrderId;

    @JsonProperty("status")
    private int status;

    @JsonProperty("status_info")
    private String statusInfo;

    @JsonProperty("pay_amount")
    private String payAmount;

    @JsonProperty("third_amount")
    private String thirdAmount;

    @JsonProperty("virtual_coin_count")
    private int virtualCoinCount;

    @JsonProperty("pay_date")
    private String payDate;

    @JsonProperty("type")
    private String type;

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

    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public String getThirdAmount() {
        return thirdAmount;
    }

    public void setThirdAmount(String thirdAmount) {
        this.thirdAmount = thirdAmount;
    }

    public int getVirtualCoinCount() {
        return virtualCoinCount;
    }

    public void setVirtualCoinCount(int virtualCoinCount) {
        this.virtualCoinCount = virtualCoinCount;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

}
