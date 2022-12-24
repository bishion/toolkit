package io.github.bishion.common.dto;

import io.github.bishion.common.consts.BaseConst;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 通用分页结果对象
 *
 * @author: guofangbi
 * @version: 1.0.0
 * @since 2022-05-24 23:01:40
 */
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = 7796860184313107460L;
    private final Integer total;
    private final List<T> records;

    public PageResult(Integer total, List<T> records) {
        this.total = total;
        this.records = records;
    }

    public static <T> PageResult<T> of(Integer total, List<T> records) {
        return new PageResult<>(total, records);
    }

    public static <T> PageResult<T> of(Long total, List<T> records) {
        return new PageResult<>(total.intValue(), records);
    }

    public static <T> PageResult<T> empty() {
        return new PageResult<T>(BaseConst.INT_0, Collections.EMPTY_LIST);
    }

    public Integer getTotal() {
        return total;
    }

    public List<T> getRecords() {
        return records;
    }
}
