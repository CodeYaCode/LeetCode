/*
 * $Header: Integer.java
 * $Revision: 1.0.0.0
 * $CreateDate: 2018年3月21日
 * $ModifyDate: 2018年3月21日
 * $Owner: LiuChen
 * 
 * Copyright (c) 2017-2027 ShangHai ChenJxx Co. Ltd.
 * All Right Reserved.
 */

/**
 * Integer.java
 * @author LiuChen
 * @version 1.0.0.0 2018年3月21日
 */
public class Integer {
    // 成员变量
    private int value;
    
    /**
     * 无参数构造函数
     */
    public Integer() {
        this.value = 0;
    }
    
    /**
     * 有参数构造函数
     * @param v
     */
    public Integer(int v) {
        this.value = v;
    }
    
    /**
     * 成员函数
     */
    @Override
    public String toString() {
        return "Value: " + String.valueOf(this.value);
    }
    
    /**
     * 成员函数
     */
    public Integer plus(Integer integer) {
        return new Integer(integer.value + this.value);
    }
    
    /**
     * 主函数，程序运行的入口函数
     */
    public static void main(String[] args) {
        Integer a = new Integer(1);
        Integer b = new Integer(2);
        System.out.println(a.plus(b));
    }
}
