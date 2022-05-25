package cn.bishion.toolkit.common.util;

import cn.bishion.toolkit.common.consts.BaseConst;

/**
 * id工具包
 *
 * @author: guofangbi
 * @date: 2022-05-25 23:09:56
 * @version: 1.0.0
 */
public class IdUtil {
    private IdUtil() {
    }

    /**
     * 使用进制，几位数代表一个字符
     */
    private static final Integer DEFAULT_CHAR_BITS = BaseConst.INT_5;
    private static final char[] DIGITS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static final String nextStr() {
        return id2Str(Snowflake.SNOWFLAKE.nextId());
    }

    /**
     * 将 id 转成 32进制的字符串
     *
     * @param id id
     * @return {@link String}
     */
    public static final String id2Str(long id) {
        int mag = Long.SIZE - Long.numberOfLeadingZeros(id);
        int chars = Math.max(((mag + (DEFAULT_CHAR_BITS - 1)) / DEFAULT_CHAR_BITS), 1);
        char[] buf = new char[chars];

        int charPos = chars;
        int radix = 1 << DEFAULT_CHAR_BITS;
        int mask = radix - 1;
        do {
            buf[0 + --charPos] = DIGITS[((int) id) & mask];
            id >>>= DEFAULT_CHAR_BITS;
        } while (id != 0 && charPos > 0);

        return new String(buf);
    }
}
