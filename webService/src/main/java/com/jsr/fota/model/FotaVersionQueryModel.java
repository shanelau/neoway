package com.jsr.fota.model;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-12-23
 * Time: 下午4:55
 * coding for fun and coding my life!
 */
public class FotaVersionQueryModel {
    String search;
    String order;

    public FotaVersionQueryModel(String search, String order) {
        this.search = search;
        this.order = order;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
