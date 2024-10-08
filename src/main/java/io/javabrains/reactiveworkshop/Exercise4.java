package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
//        ReactiveSources.intNumberMono().timeout(Duration.ofSeconds(4)).subscribe(System.out::println, (err) -> System.out.println(err.getMessage()));

        // Get the value from the Mono into an integer variable
        Optional<Integer> i = ReactiveSources.intNumberMono().blockOptional();
        System.out.println(i.orElse(-1));


        System.out.println("Press a key to end");
        System.in.read();
    }

}
