package com.github.bishion.common.dto;

import java.io.Serializable;

/**
 * 页面条件
 *
 * @author: guofangbi
 * @date: 2022-05-24 23:00:76
 * @version: 1.0.0
 */
public class PageCond implements Serializable {
    private static final long serialVersionUID = 3368920550248941612L;
    private Integer pageSize = 20;
    private Integer currentPage = 1;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
