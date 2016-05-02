package cn.mldn.shop.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Member implements Serializable {
    private String mid; // 用户ID
    private String password; //用户密码
    private String name; // 用户别名
    private String phone;//联系电话
    private String address; // 联系地址
    private Integer status;// 用户状态
    private String code; // 激活码
    private Date regdate;// 用户注册日期
    private String photo; // 用户头像
    private List<Orders> allOrders;

    public List<Orders> getAllOrders() {
        return allOrders;
    }

    public void setAllOrders(List<Orders> allOrders) {
        this.allOrders = allOrders;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
