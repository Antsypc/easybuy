package com.gentlemen.easybuy.entity;

/**
 * @author ants_ypc
 * @version 1.0 6/29/16
 */
public class Category {
    private int id;
    private String name;
    private String description;
    private int parent;

    public Category() {
    }

    public Category(int id, String name, String description, int parent) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.parent = parent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", parent=" + parent +
                '}';
    }
}
