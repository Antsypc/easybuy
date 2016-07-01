package com.gentlemen.easybuy.entity;

/**
 * @author ants_ypc
 * @version 1.0 6/29/16
 */
public class Image {
    private int id;
    private int gid;
    private String path;

    public Image() {
    }

    public Image(int id, int gid, String path) {
        this.id = id;
        this.gid = gid;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", gid=" + gid +
                ", path='" + path + '\'' +
                '}';
    }
}
