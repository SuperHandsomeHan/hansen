package edu.nf.hansen.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Achine
 * @date 2019/11/18
 */
public class RepairInfo {
    private String rId;
    private String remarks;
    private Users user;
    private String carUserName;
    private String carUserTel;
    private Date rtime;
    private Goods goods;
    private BigDecimal price;

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
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
}
