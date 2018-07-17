package test.no33;

import code.no33.Plant;

import java.util.*;
import java.util.stream.Collectors;

public class PlantTest {
    public final static Plant[] plants = buildPlants();

    public static void main(String[] args) {
//        old();
//        modern();
        simplestOld();
        simplestModern();

    }

    //使用了默认的map
    public static void simplestOld() {
        long t1 = System.currentTimeMillis();
        Arrays.stream(plants)
                .collect(Collectors.groupingBy(p -> p.lifeCycle));
        System.out.println(System.currentTimeMillis() - t1);
    }

    public static void simplestModern() {
        long t1 = System.currentTimeMillis();
        Arrays.stream(plants)
                .collect(Collectors.groupingBy(p -> p.lifeCycle,
                        () -> new EnumMap<>(Plant.LifeCycle.class), Collectors.toSet()));
        System.out.println(System.currentTimeMillis() - t1);
    }

    public static void old() {
        long t1 = System.currentTimeMillis();
        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            plantsByLifeCycle[i] = new HashSet<>();
        }
        for (Plant plant : plants) {
            plantsByLifeCycle[plant.lifeCycle.ordinal()].add(plant);
        }
        System.out.println(System.currentTimeMillis() - t1);
    }

    public static void modern() {
        long t1 = System.currentTimeMillis();
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);
        for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lc, new HashSet<>());
        }
        for (Plant plant : plants) {
            plantsByLifeCycle.get(plant.lifeCycle).add(plant);
        }
        System.out.println(System.currentTimeMillis() - t1);
    }

    public static Plant[] buildPlants() {
        final int size = 100000;
        Plant[] plants = new Plant[size];
        for (int i = 0; i < plants.length; i++) {
            if (i % 3 == 0) {
                plants[i] = new Plant(i + "", Plant.LifeCycle.ANNUAL);
            } else if (i % 3 == 1) {
                plants[i] = new Plant(i + "", Plant.LifeCycle.PERENNIAL);
            } else {
                plants[i] = new Plant(i + "", Plant.LifeCycle.BIENNIAL);
            }

        }
        return plants;
    }
}
