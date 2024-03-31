package com.duanzm.produce.entity;

public class CategoryEntity {
    private String cat_id;

    private String name;

    private String parent_cid;

    private String cat_level;

    private String show_status;

    private String sort;

    private String icon;

    private String product_unit;

    private String product_count;

    public CategoryEntity() {
    }

    public CategoryEntity(String cat_id, String name, String parent_cid, String cat_level, String show_status, String sort, String icon, String product_unit, String product_count) {
        this.cat_id = cat_id;
        this.name = name;
        this.parent_cid = parent_cid;
        this.cat_level = cat_level;
        this.show_status = show_status;
        this.sort = sort;
        this.icon = icon;
        this.product_unit = product_unit;
        this.product_count = product_count;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent_cid() {
        return parent_cid;
    }

    public void setParent_cid(String parent_cid) {
        this.parent_cid = parent_cid;
    }

    public String getCat_level() {
        return cat_level;
    }

    public void setCat_level(String cat_level) {
        this.cat_level = cat_level;
    }

    public String getShow_status() {
        return show_status;
    }

    public void setShow_status(String show_status) {
        this.show_status = show_status;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getProduct_unit() {
        return product_unit;
    }

    public void setProduct_unit(String product_unit) {
        this.product_unit = product_unit;
    }

    public String getProduct_count() {
        return product_count;
    }

    public void setProduct_count(String product_count) {
        this.product_count = product_count;
    }
}
