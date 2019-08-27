package com.baidu.entity;

import java.util.Date;

public class Order {
    private Integer oid;
    private String oname;
    private String cname;
    private Date qtime;
    private String qixian;
    private Date ytime;
    private String beizhu;
    private Integer ooid;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Date getQtime() {
        return qtime;
    }

    public void setQtime(Date qtime) {
        this.qtime = qtime;
    }

    public String getQixian() {
        return qixian;
    }

    public void setQixian(String qixian) {
        this.qixian = qixian;
    }

    public Date getYtime() {
        return ytime;
    }

    public void setYtime(Date ytime) {
        this.ytime = ytime;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public Integer getOoid() {
        return ooid;
    }

    public void setOoid(Integer ooid) {
        this.ooid = ooid;
    }
}
