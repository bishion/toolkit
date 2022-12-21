package com.github.bishion.common.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.*;

/**
 * @author: guofangbi
 * @date: 2022/6/5-11:35
 * @version: 1.0.0
 */
public class ToString {
    private ToString() {
    }

    public static String toStringWithNull(Object obj, String... excludeFields) {
        if (Objects.isNull(obj)) {
            return null;
        }
        return ReflectionToStringBuilder.toStringExclude(obj, excludeFields);
    }

    public static String toString(Object obj) {
        if (Objects.isNull(obj)) {
            return null;
        }
        return ToStringBuilder.reflectionToString(obj, new NoNullStyle());
    }

    public static String toStringExt(Object obj, String... excludeFields) {
        if (Objects.isNull(obj)) {
            return null;
        }
        return ToStringBuilder.reflectionToString(obj, new NoNullExtStyle(excludeFields));
    }
}

class NoNullStyle extends ToStringStyle implements Serializable {

    private static final long serialVersionUID = 2347542971151578670L;
    private static final CharSequence SECRET_FIELD = "secret";

    NoNullStyle() {
        super();
        this.setUseShortClassName(true);
        this.setUseIdentityHashCode(false);
    }

    @Override
    public void append(StringBuffer buffer, String fieldName, Object value, Boolean fullDetail) {
        if (value != null && !StringUtils.containsIgnoreCase(fieldName, SECRET_FIELD)) {
            super.append(buffer, fieldName, value, fullDetail);
        }
    }
}

class NoNullExtStyle extends ToStringStyle implements Serializable {

    private static final long serialVersionUID = 2347542971151578670L;
    private Set<String> ignoreFields;

    NoNullExtStyle(String[] fields) {
        super();
        this.setUseIdentityHashCode(false);

        if (fields.length == 0) {
            this.ignoreFields = Collections.emptySet();
        } else {
            this.ignoreFields = new HashSet<>(Arrays.asList(fields));
        }
    }

    @Override
    public void append(StringBuffer buffer, String fieldName, Object value, Boolean fullDetail) {
        if (value != null && !ignoreFields.contains(fieldName)) {
            super.append(buffer, fieldName, value, fullDetail);
        }
    }
}
