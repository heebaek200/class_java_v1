package com.oop4;

public class UserInfo {

    String userId;
    String userPassword;
    String username;
    String userAddress;
    String phoneNumber;

    // 생성자 - 객체가 생성될 때 가장 먼저 실행됨

    public UserInfo(String id) {
        userId = id;
    }

    public UserInfo(String u, String password) {
        userId = u;
        userPassword = password;
    }

    // 생성자 만들어 보기
    public UserInfo(String id, String password, String name, String address, String number) {
        userId = id;
        userPassword = password;
        username = name;
        userAddress = address;
        phoneNumber = number;
    }

}
