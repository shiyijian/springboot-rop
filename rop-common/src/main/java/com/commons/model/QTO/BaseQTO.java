package com.commons.model.QTO;

import java.io.Serializable;

public class BaseQTO implements Serializable{

    private Long id;
    private Integer deleteMark = 0;
    private int offset = 0;
    private int count = 100;
    private String orderByAsc;
    private String orderByDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDeleteMark() {
        return deleteMark;
    }

    public void setDeleteMark(Integer deleteMark) {
        this.deleteMark = deleteMark;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getOrderByAsc() {
        return orderByAsc;
    }

    public void setOrderByAsc(String orderByAsc) {
        this.orderByAsc = orderByAsc;
    }

    public String getOrderByDesc() {
        return orderByDesc;
    }

    public void setOrderByDesc(String orderByDesc) {
        this.orderByDesc = orderByDesc;
    }
}
