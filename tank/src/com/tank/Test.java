package com.tank;

public class Test {
    public static void main(String[] args) {
        System.out.println(ResourceMgr.class.getClassLoader().getResourceAsStream("images"));
        System.out.println(ResourceMgr.class.getResource("/"));
    }
}
