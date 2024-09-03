package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;

public class Exercise9 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Print size of intNumbersFlux after the last item returns
//        Long count = ReactiveSources.intNumbersFlux().toStream().count();//This is blocking // until the stream
        //until the stream is evaluated it will wait and do count on it
//        Mono<Long> size = ReactiveSources.intNumbersFlux().count();
//        size.subscribe();

        // Collect all items of intNumbersFlux into a single list and print it
//        List<Integer> list = ReactiveSources.intNumbersFlux().toStream().toList();//this is blocking
//        ReactiveSources.intNumbersFlux().collectList().subscribe(System.out::println);

        // Transform to a sequence of sums of adjacent two numbers


        Mono<List<Integer>> listMono = ReactiveSources.intNumbersFlux().buffer(2).map(list -> list.stream().mapToInt(Integer::intValue).sum()).collectList();
        listMono.subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
