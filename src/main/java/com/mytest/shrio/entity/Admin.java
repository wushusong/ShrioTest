package com.mytest.shrio.entity;

public class Admin {

    private Integer adminId;
    private String uname;
    private String pwd;
    private String name;
    private Integer roleId;
    private String salt;
    private Integer hashIterator;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getHashIterator() {
        return hashIterator;
    }

    public void setHashIterator(Integer hashIterator) {
        this.hashIterator = hashIterator;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", roleId=" + roleId +
                ", salt='" + salt + '\'' +
                ", hashIterator=" + hashIterator +
                '}';
    }
}
