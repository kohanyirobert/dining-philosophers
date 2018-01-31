package com.codecool.philosophers;


public class Main {

    public static void main(String[] args) {
        Simulation sim = new Simulation();
        sim.setup(5);
        sim.runSimulation();
        System.out.println("program finished");
    }
}