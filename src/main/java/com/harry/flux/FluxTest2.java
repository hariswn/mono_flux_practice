package com.harry.flux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FluxTest2 {

//    public Flux<String> fruitsFluxMap() {
//        return Flux.fromIterable(List.of("Mango","Orange","Banana"))
//                .flatMap(s -> Flux.just(s.split(""))).log();
////                .map(String::toUpperCase).log();
//    }

//    public Flux<String> fruitsFluxMap() {
//        return Flux.fromIterable(List.of("Mango","Orange","Banana"))
////                .map(String::toUpperCase).log();
//                .flatMap(i -> Mono.fromCallable(i::toLowerCase))
//                .log();
//
//    }

    public Flux<String> fruitsFluxFlatMap() {
        List<String> list = new ArrayList<>();
        list.add("Mango");
        list.add(null);
        list.add("Orange");
        return Flux.fromIterable(list)
                .log()
                .flatMap(s -> {
                   return Flux.just(s.split(""));
                });
    }

    public Flux<String> fruitsFluxFlatMapAsync() {
        return Flux.fromIterable(List.of("Mango","Orange","Banana"))
                .flatMap(s -> Flux.just(s.split(""))
                        .delayElements(Duration.ofMillis(
                                new Random().nextInt(1000)
                        )))
                .log();
    }


    public static void main(String[] args) {

        FluxTest2 fluxAndMonoServices
                = new FluxTest2();

        fluxAndMonoServices.fruitsFluxFlatMap()
                .subscribe(s -> {
                    System.out.println("s = " + s);
                });

        fluxAndMonoServices.fruitsFluxFlatMapAsync()
                .subscribe(s -> {
                    System.out.println("s = " + s);
                });

//        var events = Flux.range(1, 1000)
//                .flatMap(i -> Mono.fromCallable(() -> i))
//                .log();
//
//        events.subscribe();
//        fluxAndMonoServices.fruitsFluxMap()
//                .subscribe(s -> {
//                    System.out.println("s = " + s);
//                });
    }
}
