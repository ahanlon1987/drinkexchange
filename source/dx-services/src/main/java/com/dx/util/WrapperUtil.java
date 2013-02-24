package com.dx.util;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.util.Date;

public final class WrapperUtil {
    public static final String WRAPPER_UTIL_BOOLEAN_TRUE = "1";

    private WrapperUtil() {
        //hiding public constructor
    }

    public static boolean isBlank(Long wrapper) {
        return (wrapper == null || wrapper.longValue() <= 0L);
    }

    public static boolean isNotBlank(Long wrapper) {
        return !isBlank(wrapper);
    }

    public static boolean isBlank(Integer wrapper) {
        return (wrapper == null || wrapper.intValue() <= 0);
    }

    public static boolean isNotBlank(Integer wrapper) {
        return !isBlank(wrapper);
    }

    public static boolean isBlank(Boolean wrapper) {
        return (wrapper == null);
    }

    public static boolean isNotBlank(Boolean wrapper) {
        return !isBlank(wrapper);
    }

    public static boolean isBlank(BigDecimal wrapper) {
        return (wrapper == null || wrapper.equals(BigDecimal.ZERO));
    }

    public static boolean isNotBlank(BigDecimal wrapper) {
        return !isBlank(wrapper);
    }

    public static boolean convertStringToBoolean(String value) {
        return (value != null && value.trim().equals(WRAPPER_UTIL_BOOLEAN_TRUE));
    }

    public static boolean isBlank(String wrapper) {
        return StringUtils.isBlank(wrapper);
    }

    public static boolean isNotBlank(String wrapper) {
        return StringUtils.isNotBlank(wrapper);
    }

    public static boolean isBlank(Object[] wrapper) {
        return ArrayUtils.isEmpty(wrapper);
    }

    public static boolean isNotBlank(Object[] wrapper) {
        return ArrayUtils.isNotEmpty(wrapper);
    }

    public static boolean isBlank(Date wrapper) {
        return (wrapper == null);
    }

    public static boolean isNotBlank(Date wrapper) {
        return !isBlank(wrapper);
    }

    public static boolean isEmpty(Object[] wrapper) {
        return ArrayUtils.isEmpty(wrapper);
    }

    public static boolean isNotEmpty(Object[] wrapper) {
        return ArrayUtils.isNotEmpty(wrapper);
    }

    /* renamed due to SONAR complaint */
    public static boolean objectComparison(Object var1, Object var2){
        return var1 == null ? var2 == null : var1.equals(var2);
    }
}
