package com.jsr.common.model;

import com.jsr.common.pagination.Page;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liu.xing
 * Date: 13-11-23
 * Time: 上午10:29
 * coding for fun and coding my life!
 */
public class DataTableBean {
    private int iTotalRecords;
    private int iTotalDisplayRecords;
    private List aaData ;
    private int sEcho;

    public DataTableBean(Page page, int sEcho) {
        this.iTotalRecords = page.getContext().getTotal();
        this.iTotalDisplayRecords = page.getContext().getTotal();
        this.aaData = page.getItems();
        this.sEcho = sEcho;
    }

    public int getiTotalRecords() {
        return iTotalRecords;
    }

    public void setiTotalRecords(int iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public int getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public List getAaData() {
        return aaData;
    }

    public void setAaData(List aaData) {
        this.aaData = aaData;
    }

    public int getsEcho() {
        return sEcho;
    }

    public void setsEcho(int sEcho) {
        this.sEcho = sEcho;
    }
}
