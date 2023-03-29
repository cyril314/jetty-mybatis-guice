package com.fit.core.base;

/**
 * @className: PageInfo
 * @description: 分页
 * @author: Aim
 * @date: 2023/3/29
 **/
public class PageInfo {

    private int pageNo;

    private int pageSize;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
