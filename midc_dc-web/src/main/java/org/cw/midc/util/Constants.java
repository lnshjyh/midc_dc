package org.cw.midc.util;

import com.google.common.collect.Sets;

import java.util.Set;

public class Constants {
    public static final String ALGORITHM_NAME = "SHA-256"; // 加密算法
    public static final int HASH_ITERATIONS = 2; // 加密次数

    public static final Set<Integer> STATUS_SET =Sets.newHashSet(0,1);
    
    public static final String REPORT_STATUS_PRE_DIAGNOSE = "1";
    public static final String REPORT_STATUS_APPROVED = "2";
    
    //基层到中心
    public static final String STUDYINFO_TRANS_STATUS_B2C = "1";
    //中心到基层
    public static final String STUDYINFO_TRANS_STATUS_C2B = "2";
   
}
