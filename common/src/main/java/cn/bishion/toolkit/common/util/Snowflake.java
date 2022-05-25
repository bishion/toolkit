package cn.bishion.toolkit.common.util;

import cn.bishion.toolkit.common.consts.BaseConst;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.text.CharSequenceUtil;

/**
 * 雪花
 *
 * @author: guofangbi
 * @date: 2022-05-25 23:08:23
 * @version: 1.0.0
 */
enum Snowflake {
    /**
     * 雪花算法，生成的数字长度为 60 位定长 2 进制数：
     * 1 - 第 3 IP段 - 第 4 IP段 - 一毫秒内不重复数 - 当前距离预定时间的毫秒数
     * 0 - 00000000 - 00000000 - 00 -
     * 00000000000000000000000000000000000000000
     */
    SNOWFLAKE;
    private long sequence = 0L;
    private long lastTimestamp = -1L;
    /**
     * 默认时间偏移量，允许的时钟回拨数
     */
    private static final long DEFAULT_TIME_OFFSET = 2000L;
    /**
     * 默认的起始时间，为北京时间 2022-02-22 22:22:22
     */
    private static final long START_TIME = 1645539742000L;
    /**
     * 位序列，// 序列号2位（表示只允许序列号的范围为：0-3）
     */
    private static final int SEQUENCE_BITS = 2;
    private static final long SEG3_IP = NetUtil.getLocalhost().getAddress()[BaseConst.INT_2] & 0xff;
    private static final long SEG4_IP = NetUtil.getLocalhost().getAddress()[BaseConst.INT_3] & 0xff;
    /**
     * 这里使用IP地址后两段作为雪花算法中的数据中心和机器节点
     */
    private static final int IP_SEG_SIZE = 8;
    private static final int FIRST_SEG_SIZE = 1;


    private static final Integer MAX_BITS = 60;
    /**
     * 第一个位固定为 1
     */
    private static final long FIRST_SEG_VALUE = 1L << MAX_BITS - FIRST_SEG_SIZE;
    /**
     * 接下来 8 位是IP的第四段
     */
    private static final int IP_SEG4_SHIFT = MAX_BITS - FIRST_SEG_SIZE - IP_SEG_SIZE;
    /**
     * 再接下来 8 位是IP的第三段
     */
    private static final int IP_SEG3_SHIFT = IP_SEG4_SHIFT - IP_SEG_SIZE;
    /**
     * 再接下来是 2 位的seq，表示一毫秒可以生成3个id不重复
     */
    private static final int TIME_SHIFT = SEQUENCE_BITS;
    /**
     * 最大的序列值为3
     */
    private static final long SEQUENCE_MASK = ~(-1L << SEQUENCE_BITS);

    private static final long DEFAULT_PREFIX = FIRST_SEG_VALUE | SEG4_IP << IP_SEG4_SHIFT | (SEG3_IP << IP_SEG3_SHIFT);

    public synchronized long nextId() {
        long timestamp = System.currentTimeMillis();
        if (timestamp < this.lastTimestamp) {
            if (this.lastTimestamp - timestamp < DEFAULT_TIME_OFFSET) {
                // 容忍指定的回拨，避免NTP校时造成的异常
                timestamp = lastTimestamp;
            } else {
                // 如果服务器时间有问题(时钟后退) 报错。
                throw new IllegalStateException(CharSequenceUtil
                        .format("Clock moved backwards. Refusing to generate id for {}ms", lastTimestamp - timestamp));
            }
        }

        if (timestamp == this.lastTimestamp) {
            final long tempSeq = (this.sequence + 1) & SEQUENCE_MASK;
            if (tempSeq == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
            this.sequence = tempSeq;
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;
        return DEFAULT_PREFIX | (timestamp - START_TIME) << TIME_SHIFT | sequence;
    }

    /**
     * 循环等待下一个时间
     *
     * @param lastTimestamp 上次记录的时间
     * @return 下一个时间
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        // 循环直到操作系统时间戳变化
        while (timestamp == lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        if (timestamp < lastTimestamp) {
            // 如果发现新的时间戳比上次记录的时间戳数值小，说明操作系统时间发生了倒退，报错
            throw new IllegalStateException(CharSequenceUtil.format("Clock moved backwards. Refusing to generate id for {}ms",
                    lastTimestamp - timestamp));
        }
        return timestamp;
    }
}
