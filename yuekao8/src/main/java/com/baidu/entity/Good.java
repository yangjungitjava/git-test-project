package com.baidu.entity;

import java.util.Date;

public class Good {
    private Integer gid;
    private String gname;
    private Integer cid;
    private String cname;
    private Double price;
    private Date gtime;
    private String shangjia;
    private  Integer uid;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getGtime() {
        return gtime;
    }

    public void setGtime(Date gtime) {
        this.gtime = gtime;
    }

    public String getShangjia() {
        return shangjia;
    }

    public void setShangjia(String shangjia) {
        this.shangjia = shangjia;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
