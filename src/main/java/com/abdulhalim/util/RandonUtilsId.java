package com.abdulhalim.util;

import java.util.UUID;

public class RandonUtilsId {
    public String getUuid() {
        return UUID.randomUUID().toString().replace("-","").substring(0,4);
    }
}
