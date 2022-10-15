package com.atgu;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.concurrent.CyclicBarrier;

public enum  CountryEnum {
    //六国顺序是 韩、赵、魏、楚、燕、齐
    ONE(1,"韩国"),TWo(2,"赵国"),Three(3,"魏国"),
    Four(4,"楚国"),Five(5,"燕国"),Six(6,"齐国");
     private Integer retCode;
     private String retMessage;
public static CountryEnum forEach_country(int idex){
    CountryEnum[] values = CountryEnum.values();
    for (CountryEnum value : values) {
        if (value.retCode==idex)return value;
    }
    return null;



}

    public Integer getRetCode() {
        return retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

}
