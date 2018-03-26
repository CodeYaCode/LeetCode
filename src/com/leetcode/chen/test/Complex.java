/*
 * $Header: Complex.java
 * $Revision: 1.0.0.0
 * $CreateDate: 2018年3月21日
 * $ModifyDate: 2018年3月21日
 * $Owner: LiuChen
 * 
 * Copyright (c) 2017-2027 ShangHai ChenJxx Co. Ltd.
 * All Right Reserved.
 */
package com.leetcode.chen.test;

/**
 * Complex.java
 * 
 * @author LiuChen
 * @version 1.0.0.0 2018年3月21日
 */
public class Complex {
    // 实部
    private double real;
    // 虚部
    private double imaginary;

    public Complex(double r, double i) {
        this.real = r;
        this.imaginary = i;
    }

    @Override
    public String toString() {
        return this.real + "+" + this.imaginary + "i";
    }

    /**
     * 共轭
     * 
     * @param com
     * @return
     */
    public Complex conjugate() {
        return new Complex(this.real, -this.imaginary);
    }

    /**
     * 加法
     * 
     * @param com
     * @return
     */
    public Complex plus(Complex com) {
        return new Complex(this.real + com.real, this.imaginary + com.imaginary);
    }

    /**
     * 减法
     * 
     * @param com
     * @return
     */
    public Complex substract(Complex com) {
        return new Complex(this.real - com.real, this.imaginary - com.imaginary);
    }

    /**
     * 乘法
     * 
     * @param com
     * @return
     */
    public Complex multiple(Complex com) {
        double newReal = this.real * com.real - this.imaginary * com.imaginary;
        double newImaginary = this.real * com.imaginary + this.imaginary * com.real;
        return new Complex(newReal, newImaginary);
    };

    /**
     * 除法
     * 
     * @param com
     * @return
     */
    public Complex division(Complex com) {
        Complex c = this.multiple(com.conjugate());
        Complex denominator = com.multiple(com.conjugate());
        return new Complex(c.real/denominator.real, c.imaginary/denominator.real);
    }
    
    public void print() {
        System.out.println(this.toString());
    }
    
    public static void main(String[] args) {
        Complex c1 = new Complex(1,2);
        Complex c2 = new Complex(3,4);
        c1.print();
        c2.print();
        c1.plus(c2).print();
        c1.substract(c2).print();
        c1.multiple(c2).print();
        c1.division(c2).print();
    }
//        System.out.println(c1);
//        System.out.println(c2);
//        System.out.println(c1.plus(c2));
//        System.out.println(c1.substract(c2));
//        System.out.println(c1.multiple(c2));
//        System.out.println(c1.division(c2));
//    }
}
