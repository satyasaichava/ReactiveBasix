package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberFlux() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
//        ReactiveSources.intNumbersFlux().subscribe(
//                System.out::println,
//                (err) -> System.out.println(err.getMessage()),
//                () -> System.out.println("completed")
//        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new Mysubscriber<>());
        System.out.println("Press a key to end");
        System.in.read();
    }

    static class Mysubscriber<T> extends BaseSubscriber<T> {
        @Override
        protected void hookOnSubscribe(Subscription subscription) {
            System.out.println("Subscribe started");
            request(1);

        }

        @Override
        protected void hookOnNext(T value) {
            System.out.println("Value received :: " + value);
            request(3);
        }

        @Override
        protected void hookOnComplete() {
            System.out.println("Completed......");
        }
    }

}