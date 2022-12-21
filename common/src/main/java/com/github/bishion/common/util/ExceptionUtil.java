package com.github.bishion.common.util;


import com.github.bishion.common.consts.BaseConst;

import java.lang.reflect.InvocationTargetException;

public class ExceptionUtil {
    public static String printStackWith10Lines(Throwable t) {
        return printStackWithExpectLine(t, BaseConst.INT_10);
    }

    public static String printStackWithExpectLine(Throwable t, int stackLines) {
        if (t instanceof InvocationTargetException) {
            t = ((InvocationTargetException) t).getTargetException();
        }
        StackTraceElement[] stackTrace = t.getStackTrace();
        StringBuilder sb = new StringBuilder(t.toString());

        if (stackLines > stackTrace.length) {
            stackLines = stackTrace.length;
        }

        for (int i = 0; i < stackLines; i++) {
            sb.append(" ").append(stackTrace[i].toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}

