package com.codecool.philosophers;

public class Chopstick {

    synchronized public void pickup() throws InterruptedException {
        wait(100);
    }
}
