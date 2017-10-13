package com.hmcc.contact.entity;



/**
 * Created by LiZhengTao on 2017/10/12.
 */
public class ContactUser {
    private String userid;

    private String username;

    private String usergender;

    private String orgid;

    private String userduty;

    private String userphonenum;

    private String ishidden;

    private String userposition;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsergender() {
        return usergender;
    }

    public void setUsergender(String usergender) {
        this.usergender = usergender;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getUserduty() {
        return userduty;
    }

    public void setUserduty(String userduty) {
        this.userduty = userduty;
    }

    public String getUserphonenum() {
        return userphonenum;
    }

    public void setUserphonenum(String userphonenum) {
        this.userphonenum = userphonenum;
    }

    public String getIshidden() {
        return ishidden;
    }

    public void setIshidden(String ishidden) {
        this.ishidden = ishidden;
    }

    public String getUserposition() {
        return userposition;
    }

    public void setUserposition(String userposition) {
        this.userposition = userposition;
    }

    @Override
    public String toString() {
        return "ContactUser{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", usergender='" + usergender + '\'' +
                ", orgid='" + orgid + '\'' +
                ", userduty='" + userduty + '\'' +
                ", userphonenum='" + userphonenum + '\'' +
                ", ishidden='" + ishidden + '\'' +
                ", userposition='" + userposition + '\'' +
                '}';
    }
}
