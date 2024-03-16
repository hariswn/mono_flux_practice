package com.harry.mono;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class MonoTest2 {

    public Mono<List<String>> fruitMonoFlatMap() {
        return Mono.just("Mango")
                .flatMap(s -> Mono.just(List.of(s.split(""))))
                .log();
    }

    public Flux<String> fruitMonoFlatMapMany() {
        return Mono.just("Mango")
                .flatMapMany(s -> Flux.just(s.split("")))
                .log();
    }

    public static void main(String[] args) {

        MonoTest2 fluxAndMonoServices
                = new MonoTest2();

        fluxAndMonoServices.fruitMonoFlatMap()
                .subscribe(s -> {
                    System.out.println("s = " + s);
                });

        fluxAndMonoServices.fruitMonoFlatMapMany()
                .subscribe(s -> {
                    System.out.println("Mono -> s = " + s);
                });
    }
}
