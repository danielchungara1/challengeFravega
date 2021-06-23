package com.danisoft.challengeFravega.layers.business;

public class BusinessException extends RuntimeException{

    public BusinessException(String msg) {
        super(msg);
    }

    public static void throwException(String msg) {
        throw new BusinessException(msg);
    }

}
