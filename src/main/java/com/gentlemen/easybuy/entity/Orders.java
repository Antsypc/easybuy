package com.gentlemen.easybuy.entity;

import java.sql.Timestamp;

/**
 * @author ants_ypc
 * @version 1.0 6/29/16
 */
public class Orders {
    private int id;
    private int uid;
    private int gid;
    private Timestamp time;
    private int sum;
    private int state;
    private double total;

    public Orders() {
    }

    public Orders(int id, int uid, int gid, Timestamp time, int sum, int state, double total) {
        this.id = id;
        this.uid = uid;
        this.gid = gid;
        this.time = time;
        this.sum = sum;
        this.state = state;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", uid=" + uid +
                ", gid=" + gid +
                ", time=" + time +
                ", sum=" + sum +
                ", state=" + state +
                ", total=" + total +
                '}';
    }
}
