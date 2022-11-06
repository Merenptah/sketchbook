package com.hg.sketchbook;

import com.hg.sketchbook.validations.Address;

import java.util.Set;

import static com.hg.sketchbook.validations.Role.*;

public class Main {
    public static void main(String[] args) {
        Address.of(Set.of(LOTTERY_ADDRESS), null, null, "Musterstr.", "123", null)
                .onSuccess(System.out::println);
        Address.of(Set.of(LOTTERY_ADDRESS), null, null, "Musterstr.", "", null)
                .orElse(System.out::println);
        Address.of(Set.of(LOTTERY_ADDRESS), null, null, "", "", null)
                .orElse(System.out::println);

        Address.of(Set.of(CITY_INDICATING_ADDRESS), "Berlin", "12345", "Musterstr.", "123",
                        null)
                .onSuccess(System.out::println);
        Address.of(Set.of(CITY_INDICATING_ADDRESS), "Berlin", null, "Musterstr.", "", null)
                .orElse(System.out::println);
        Address.of(Set.of(CITY_INDICATING_ADDRESS), null, null, "", "", null)
                .orElse(System.out::println);

        Address.of(Set.of(CITY_INDICATING_ADDRESS, LOTTERY_ADDRESS), "Berlin", "12345", "Musterstr.",
                        "123",
                        null)
                .onSuccess(System.out::println);
        Address.of(Set.of(CITY_INDICATING_ADDRESS, LOTTERY_ADDRESS), "Berlin", null, "Musterstr.", "", null)
                .orElse(System.out::println);
        Address.of(Set.of(CITY_INDICATING_ADDRESS, LOTTERY_ADDRESS), null, null, "", "", null)
                .orElse(System.out::println);

        Address.of(Set.of(MAIN_ADDRESS), "Berlin", "12345", "Musterstr.",
                        "123",
                        null)
                .onSuccess(System.out::println);

        Address.of(Set.of(MAIN_ADDRESS), "", "12345", "Musterstr.",
                        "123",
                        null)
                .orElse(System.out::println);
    }
}