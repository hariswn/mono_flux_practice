package com.harry.flux;

import reactor.core.publisher.Flux;

import java.util.List;

public class FluxTest1 {

    public Flux<String> fruitsFlux() {
        return Flux.fromIterable(List.of("Mango","Orange","Banana")).log();
    }

    public static void main(String[] args) {

        FluxTest1 fluxAndMonoServices
                = new FluxTest1();

        fluxAndMonoServices.fruitsFlux()
                .subscribe(s -> {
                    System.out.println("s = " + s);
                });
    }
}
