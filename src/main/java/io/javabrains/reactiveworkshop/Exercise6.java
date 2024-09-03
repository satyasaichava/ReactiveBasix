package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.time.Duration;
import java.util.Optional;

public class Exercise6 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.unresponsiveFlux() and ReactiveSources.unresponsiveMono()

        // Get the value from the Mono into a String variable but give up after 5 seconds
        Optional<String> s = ReactiveSources.unresponsiveMono().timeout(Duration.ofSeconds(5), Mono.empty()).blockOptional();
        System.out.println(s.orElse("nothing"));

        // Get the value from unresponsiveFlux into a String list but give up after 5 seconds
        // Come back and do this when you've learnt about operators!
//        String string1 = ReactiveSources.unresponsiveFlux().timeout(Duration.ofSeconds(5)).toString();
//        System.out.println(string1);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
