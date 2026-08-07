package com.oop15;

public class Computer {

    private CPU cpu;
    private GPU gpu;

    public Computer() {
        cpu = new CPU();
        gpu = new GPU();
    }

    public void onPower() {
        System.out.println("컴퓨터를 기동합니다...");

        cpu.operate();
        gpu.operate();
    }
}
