package com.mamba.houses.util;

import java.util.UUID;

/**
 * desc:
 * author:devzhong
 * Date:2018/4/5 13:15
 */
public class UuidUtil {
    public static String generate(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
