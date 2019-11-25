package edu.nf.hansen.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Achine
 * @date 2019/11/18
 */
public class RepairInfo {
    private String rid;
    private String remarks;
    private String carUserName;
    private String carUserTel;
    @JsonFormat(timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date rtime;
    private BigDecimal price;
    private String status;
    private Users user;
    private Goods goods;

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getCarUserName() {
        return carUserName;
    }

    public void setCarUserName(String carUserName) {
        this.carUserName = carUserName;
    }

    public String getCarUserTel() {
        return carUserTel;
    }

    public void setCarUserTel(String carUserTel) {
        this.carUserTel = carUserTel;
    }

    public Date getRtime() {
        return rtime;
    }

    public void setRtime(Date rtime) {
        this.rtime = rtime;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
