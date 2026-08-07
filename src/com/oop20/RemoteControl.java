package com.oop20;

public interface RemoteControl {

    // 1. 인터페이스에 선언된 필드는 자동 public static final이다. 생략되어 있다.
    int MAX_VOLUME = 10;

    // 2. 인터페이스에 선언된 메서드는 전부 추상 메서드이다. (자바 8버전 default 제외) public abstract 자동.
    void turnON();
    public abstract void turnOFF();
    void setMaxVolume(int volume);
}
