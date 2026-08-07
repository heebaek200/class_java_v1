package com.oop10;

public class StaticRuleTest {

    private String version = "1.0.0";                       // 인스턴스 변수
    private static String appName = "로또 번호 생성기";     // static 변수

    // instance 메서드
    public String getVersion() {
        System.out.println(appName);
        System.out.println(version);
        System.out.println(makeMessage());

        return version;
    }

    // static 메서드
    public static String makeMessage() {
        System.out.println(appName);    // static 변수인 appName

        //System.out.println(version);        // 不可
        //System.out.println(getVersion());   // 不可
        //System.out.println(this);           // 不可

        return appName + " 입니다.";
    }

}
