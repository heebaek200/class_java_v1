package com.oop20;


public class TV implements RemoteControl {

    private int volume;

    @Override
    public void turnON() {
        System.out.println("TV 전원을 켭니다.");
    }

    @Override
    public void turnOFF() {
        System.out.println("TV 전원을 끕니다.");
    }

    @Override
    public void setMaxVolume(int volume) {
        if (volume > MAX_VOLUME) {
            this.volume = MAX_VOLUME;
        } else if (volume < 0) {
            this.volume = 0;
        } else {
            this.volume = volume;
        }
        System.out.println("TV 볼륨을 " + this.volume + "으로 설정합니다.");
    }
}
