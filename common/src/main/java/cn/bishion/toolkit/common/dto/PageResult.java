package cn.bishion.toolkit.common.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 基本页面
 *
 * @author: guofangbi
 * @date: 2022-05-24 23:01:40
 * @version: 1.0.0
 */
public class PageResult<T extends Serializable> implements Serializable {
    private static final long serialVersionUID = 7796860184313107460L;
    private Long total;
    private List<T> records;

    public PageResult(Long total, List<T> records) {
        this.total = total;
        this.records = records;
    }

    public static <T extends Serializable> PageResult<T> of(Long total, List<T> records) {
        return new PageResult<>(total, records);
    }

    public Long getTotal() {
        return total;
    }

    public List<T> getRecords() {
        return records;
    }
}
