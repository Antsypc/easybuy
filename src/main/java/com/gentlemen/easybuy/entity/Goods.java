package com.gentlemen.easybuy.entity;

import java.sql.Timestamp;

/**
 * @author ants_ypc
 * @version 1.0 6/29/16
 */
public class Goods {
    private int id;
    private int cid;
    private String name;
    private double price;
    private double offset;
    private int storage;
    private Timestamp time;

    public Goods() {
    }

    public Goods(int id, int cid, String name, double price, double offset, int storage, Timestamp time) {
        this.id = id;
        this.cid = cid;
        this.name = name;
        this.price = price;
        this.offset = offset;
        this.storage = storage;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOffset() {
        return offset;
    }

    public void setOffset(double offset) {
        this.offset = offset;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", cid=" + cid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", offset=" + offset +
                ", storage=" + storage +
                ", time=" + time +
                '}';
    }
}
