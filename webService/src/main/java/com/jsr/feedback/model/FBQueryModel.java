package com.jsr.feedback.model;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-11-26
 * Time: 上午11:08
 * coding for fun and coding my life!
 */
public class FBQueryModel extends QueryModel{
    private String search ;
    private String  type ;
    private String statu ;
    private String order;

    public FBQueryModel(String search, String type, String statu, String order) {
        this.search = search;
        this.type = type;
        this.statu = statu;
        this.order = order;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
