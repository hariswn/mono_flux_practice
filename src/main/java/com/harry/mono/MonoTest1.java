package com.harry.mono;

import reactor.core.publisher.Mono;

public class MonoTest1 {

    public Mono<String> fruitMono() {
        return Mono.just("Mango").log()
                .then(Mono.error(new RuntimeException("Error Occurred while publishing data")));
    }

    public Mono<String> fruitsMonoZipWith() {
        var fruits = Mono.just("Mango");
        var veggies = Mono.just("Tomato");

        return fruits.zipWith(veggies,
                (first,second) -> first+second).log();
    }

    public Mono<String> fruitsMonoZip() {
        var fruits = Mono.just("Mango");
        var veggies = Mono.just("Tomato");

        return fruits.zipWith(veggies,
                (first,second) -> first+second).log();
    }

    public static void main(String[] args) {

        MonoTest1 fluxAndMonoServices
                = new MonoTest1();

        fluxAndMonoServices.fruitsMonoZipWith()
                .subscribe(s -> {
                    System.out.println("Mono -> s = " + s);
                });
    }
}
