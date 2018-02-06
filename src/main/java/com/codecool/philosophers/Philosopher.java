package com.codecool.philosophers;

public class Philosopher implements Runnable {

    private final Chopstick left;

    private final Chopstick right;

    private final String _name;

    public Philosopher(Chopstick left, Chopstick right, String name)
    {
        this.left = left;
        this.right = right;
        this._name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            eatLunch();
        }
        System.out.println(_name + ": finished eating, I'm full!");
    }

    private void eatLunch() {
        synchronized (left) {
            try {
                left.pickup();
                System.out.println(_name + " picked up left chopstick");
                synchronized (right) {
                    System.out.println(_name + " picked up right chopstick");
                    right.pickup();
                }
                eat();
            }
            catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
        }
    }

    private void eat() throws InterruptedException {
        System.out.println(_name + ": I am eating");
        Thread.sleep(100);
    }

    @Override
    public String toString() {
        return _name;
    }
}
