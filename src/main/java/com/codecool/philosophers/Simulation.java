package com.codecool.philosophers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Simulation {

    private List<Philosopher> philosophers;
    private List<Chopstick> chopsticks;
    private ArrayList<String> names = new ArrayList<>(
            Arrays.asList("Kant", "Nietzsche", "Confucius", "Plato", "Descartes", "Heidegger"));

    public void setup(int numPhilosophers) {
        philosophers = new ArrayList<>();
        chopsticks = new ArrayList<>();
        for (int i = 0; i < numPhilosophers; i++) {
            chopsticks.add(new Chopstick());
        }
        for (int i = 0; i < chopsticks.size(); i++) {
            if (i == 0) {
                philosophers.add(new Philosopher(chopsticks.get(chopsticks.size() - 1), chopsticks.get(i), getName(i)));
            }
            else {
                philosophers.add(new Philosopher(chopsticks.get(i - 1), chopsticks.get(i), getName(i)));
            }
        }
    }

    public void runSimulation() {
        for (Philosopher philosopher : philosophers) {
            Thread t = new Thread(philosopher);
            t.start();
        }
    }

    private String getName(int i) {
        return names.get(i % names.size());
    }

}
